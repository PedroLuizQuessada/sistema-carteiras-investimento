package com.quesssystems.sistemacarteirasinvestimento.exceptions;

public class OrigemAcaoInvalidaException extends RuntimeException {

    public OrigemAcaoInvalidaException() {
        super("A ação deve possuir uma origem");
    }
}
