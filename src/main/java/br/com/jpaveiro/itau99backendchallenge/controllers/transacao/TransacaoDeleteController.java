package br.com.jpaveiro.itau99backendchallenge.controllers.transacao;

import br.com.jpaveiro.itau99backendchallenge.usecases.transacao.TransacaoDeleteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TransacaoDeleteController {
    private final TransacaoDeleteService service;

    public TransacaoDeleteController(final TransacaoDeleteService service)
    {
        this.service = service;
    }

    @DeleteMapping("/transacao")
    public ResponseEntity<Void> performar()
    {
        log.info("DELETE /transacao - Início do processamento.");
        service.executar();
        log.info("DELETE /transacao - Processamento finalizado.");
        return ResponseEntity
                .status(200)
                .build();
    }
}
