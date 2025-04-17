package br.com.jpaveiro.itau99backendchallenge.services.transacao;

import br.com.jpaveiro.itau99backendchallenge.dao.TransacaoDAO;
import br.com.jpaveiro.itau99backendchallenge.dto.transacao.TransacaoPostDTO;
import br.com.jpaveiro.itau99backendchallenge.models.response.StandardResponse;
import br.com.jpaveiro.itau99backendchallenge.models.Transacao;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.Optional;

@Service
public class TransacaoPostService {
    private final TransacaoDAO dao;

    public TransacaoPostService(final TransacaoDAO dao) {
        this.dao = dao;
    }

    public StandardResponse executar(TransacaoPostDTO dto) {
        Optional<BigDecimal> valor = Optional.ofNullable(dto.valor());
        Optional<OffsetDateTime> dataHora = Optional.ofNullable(dto.dataHora());

        boolean valorValido = valor
                .map(v -> v.compareTo(BigDecimal.ZERO) >= 0)
                .orElse(false);

        boolean dataHoraValido = dataHora
                .map(d -> Duration.between(dataHora.get(), OffsetDateTime.now()).abs().toMillis() <= 1000)
                .orElse(false);

        if (!valorValido || !dataHoraValido) {
            return StandardResponse.builder()
                    .statusCode(422)
                    .mensagem("Regras de negócio: Parâmetros invalidos.")
                    .build();
        }

        dao.adicionar(new Transacao(
                        valor.get(),
                        dataHora.get()
                )
        );
        return StandardResponse.builder()
                .statusCode(201)
                .build();
    }
}
