package br.com.jpaveiro.itau99backendchallenge.usecases.transacao;

import br.com.jpaveiro.itau99backendchallenge.daos.TransacaoDAO;
import br.com.jpaveiro.itau99backendchallenge.models.domain.Transacao;
import br.com.jpaveiro.itau99backendchallenge.models.response.TransacaoEstatisticasResponse;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
public class TransacaoEstatisticaService {
    private final TransacaoDAO dao;

    public TransacaoEstatisticaService(final TransacaoDAO dao) {
        this.dao = dao;
    }

    public TransacaoEstatisticasResponse executar() {
        var dss = new DoubleSummaryStatistics();
        List<Transacao> transacoesUltimos60s = dao.listarTodosQueList(
                t -> Duration.between(t.getDataHora(), OffsetDateTime.now())
                        .toSeconds() <= 60
        );

        transacoesUltimos60s.forEach(t -> {
            dss.accept(t.getValor().doubleValue());
        });

        var min = dss.getMin();
        var max = dss.getMax();
        return TransacaoEstatisticasResponse.builder()
                .count(dss.getCount())
                .sum(dss.getSum())
                .avg(dss.getAverage())
                .min((Double.isInfinite(min) ? 0 : min))
                .max((Double.isInfinite(max) ? 0 : max))
                .build();
    }
}
