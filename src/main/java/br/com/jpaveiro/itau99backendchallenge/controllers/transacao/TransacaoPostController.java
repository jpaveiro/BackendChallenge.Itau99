package br.com.jpaveiro.itau99backendchallenge.controllers.transacao;

import br.com.jpaveiro.itau99backendchallenge.dtos.transacao.TransacaoPostDTO;
import br.com.jpaveiro.itau99backendchallenge.usecases.transacao.TransacaoPostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TransacaoPostController {
    private final TransacaoPostService service;

    public TransacaoPostController(final TransacaoPostService service)
    {
        this.service = service;
    }

    @PostMapping("/transacao")
    public ResponseEntity<Void> performar(@RequestBody final TransacaoPostDTO dto) {
        log.info("POST /transacao - Início do processamento.");
        var resposta = service.executar(dto);

        if (resposta.getStatusCode() == 422) {
            log.error("POST /transacao - {}", resposta.getMensagem());
            return ResponseEntity
                    .status(resposta.getStatusCode())
                    .build();
        }

        log.info("POST /transacao - Processamento finalizado.");
        return ResponseEntity
                .status(201)
                .build();
    }
}
