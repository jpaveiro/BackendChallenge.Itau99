package br.com.jpaveiro.itau99backendchallenge.controllers.transacao;

import br.com.jpaveiro.itau99backendchallenge.dao.TransacaoDAO;
import br.com.jpaveiro.itau99backendchallenge.dto.transacao.PostTransacaoDTO;
import br.com.jpaveiro.itau99backendchallenge.models.Transacao;
import br.com.jpaveiro.itau99backendchallenge.services.transacao.PostTransacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.Optional;

@RestController
public class PostTransacaoController {
    private final PostTransacaoService service;
    private final TransacaoDAO dao;

    public PostTransacaoController(final PostTransacaoService service, TransacaoDAO dao)
    {
        this.dao = dao;
        this.service = service;
    }

    @PostMapping("/transacao")
    public ResponseEntity<Void> perform(@RequestBody PostTransacaoDTO dto) {
        Optional<BigDecimal> valor = Optional.ofNullable(dto.valor());
        Optional<OffsetDateTime> dataHora = Optional.ofNullable(dto.dataHora());

        dao.adicionar(new Transacao(
                valor.get(),
                dataHora.get()
                )
        );

        return ResponseEntity
                .status(201)
                .build();
    }
}
