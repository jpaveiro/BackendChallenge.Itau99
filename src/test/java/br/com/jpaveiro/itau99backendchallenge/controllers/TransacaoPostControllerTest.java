package br.com.jpaveiro.itau99backendchallenge.controllers;

import br.com.jpaveiro.itau99backendchallenge.controllers.transacao.TransacaoPostController;
import br.com.jpaveiro.itau99backendchallenge.daos.TransacaoDAO;
import br.com.jpaveiro.itau99backendchallenge.dtos.transacao.TransacaoPostDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Random;

@SpringBootTest
@Slf4j
public class TransacaoPostControllerTest {
    @Autowired
    private TransacaoPostController controller;

    @Autowired
    private TransacaoDAO dao;

    private final Random random = new Random();

    @Test
    @DisplayName("Deve criar uma transação")
    void performar() {
        log.info("TEST /transacao(POST) - Início do processamento.");
        TransacaoPostDTO dto = new TransacaoPostDTO(
                BigDecimal.valueOf(random.nextDouble(10, 250)),
                OffsetDateTime.now());

        var response = controller.performar(dto);

        assertFalse(dao.listarTodos().findAny().isEmpty());
        assertFalse(response.hasBody());
        assertEquals(201, response.getStatusCode().value());
        
        log.info("TEST /transacao(POST) - Processamento finalizado.");
    }
}
