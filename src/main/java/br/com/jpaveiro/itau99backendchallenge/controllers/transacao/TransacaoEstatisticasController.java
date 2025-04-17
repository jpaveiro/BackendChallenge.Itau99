package br.com.jpaveiro.itau99backendchallenge.controllers.transacao;

import br.com.jpaveiro.itau99backendchallenge.models.response.TransacaoEstatisticasResponse;
import br.com.jpaveiro.itau99backendchallenge.services.transacao.TransacaoEstatisticasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransacaoEstatisticasController {
    private final TransacaoEstatisticasService service;

    public TransacaoEstatisticasController(TransacaoEstatisticasService service)
    {
        this.service = service;
    }

    @GetMapping("/estatistica")
    public ResponseEntity<TransacaoEstatisticasResponse> performar()
    {
        return ResponseEntity.status(200)
                .body(service.executar());
    }
}
