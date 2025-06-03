package com.quesssystems.sistemacarteirasinvestimento.exceptions;

public class NumeroAcoesEstrangeirasException extends RuntimeException {
    public NumeroAcoesEstrangeirasException(Integer numeroAcoesEstrangeirasInvalido, Integer numeroMaximoAcoesEstrangeiras) {
        super(String.format("Número de ações: %d inválido. O número máximo de ações é: %d",
                numeroAcoesEstrangeirasInvalido, numeroMaximoAcoesEstrangeiras));
    }
}
