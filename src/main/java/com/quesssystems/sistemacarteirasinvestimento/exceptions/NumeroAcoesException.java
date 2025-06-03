package com.quesssystems.sistemacarteirasinvestimento.exceptions;

public class NumeroAcoesException extends RuntimeException {
    public NumeroAcoesException(Integer numeroAcoesInvalido, Integer numeroMaximoAcoes) {
        super(String.format("Número de ações: %d inválido. O número máximo de ações é: %d", numeroAcoesInvalido, numeroMaximoAcoes));
    }
}
