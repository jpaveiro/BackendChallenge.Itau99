package br.com.jpaveiro.itau99backendchallenge.controllers.transacao;

import br.com.jpaveiro.itau99backendchallenge.models.response.TransacaoEstatisticasResponse;
import br.com.jpaveiro.itau99backendchallenge.usecases.transacao.TransacaoEstatisticaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TransacaoEstatisticasController {
    private final TransacaoEstatisticaService service;

    public TransacaoEstatisticasController(TransacaoEstatisticaService service)
    {
        this.service = service;
    }

    @GetMapping("/estatistica")
    public ResponseEntity<TransacaoEstatisticasResponse> performar()
    {
        log.info("GET /estatistica - Início do processamento.");
        var resposta = service.executar();
        log.info("GET /estatistica - Processamento finalizado.");

        return ResponseEntity.status(200)
                .body(resposta);
    }
}
