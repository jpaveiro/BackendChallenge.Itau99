package br.com.jpaveiro.itau99backendchallenge.models.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StandardResponse {
    private final int statusCode;
    private final String mensagem;

    public StandardResponse(final int statusCode) {
        this.statusCode = statusCode;
        this.mensagem = "";
    }

    public StandardResponse(final int statusCode, final String mensagem) {
        this.statusCode = statusCode;
        this.mensagem = mensagem;
    }
}
