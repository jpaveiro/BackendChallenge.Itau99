package br.com.jpaveiro.itau99backendchallenge.dto.transacao;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record TransacaoPostDTO(BigDecimal valor, OffsetDateTime dataHora) {

}
