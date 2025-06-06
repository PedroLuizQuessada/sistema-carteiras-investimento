package com.quesssystems.sistemacarteirasinvestimento.exceptions;

public class NomeMoedaException extends RuntimeException {
    public NomeMoedaException() {
        super("A moeda deve possuir um nome");
    }
}
