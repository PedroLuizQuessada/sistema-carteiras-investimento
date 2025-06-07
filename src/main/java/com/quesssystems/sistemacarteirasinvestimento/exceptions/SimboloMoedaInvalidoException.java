package com.quesssystems.sistemacarteirasinvestimento.exceptions;

public class SimboloMoedaInvalidoException extends RuntimeException {
    public SimboloMoedaInvalidoException() {
        super("A moeda deve possuir um símbolo");
    }
}
