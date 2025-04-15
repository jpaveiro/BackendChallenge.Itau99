package br.com.jpaveiro.itau99backendchallenge.models;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class Transacao {
    private final BigDecimal valor;
    private final OffsetDateTime dataHora;

    public Transacao(BigDecimal valor, OffsetDateTime dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;
    }
}
