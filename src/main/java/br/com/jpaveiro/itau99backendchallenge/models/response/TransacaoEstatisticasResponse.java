package br.com.jpaveiro.itau99backendchallenge.models.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TransacaoEstatisticasResponse {
    private final Long count;
    private final double sum;
    private final double avg;
    private final double min;
    private final double max;
}
