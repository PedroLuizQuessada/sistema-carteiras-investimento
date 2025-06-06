package com.quesssystems.sistemacarteirasinvestimento.exceptions;

public class NomeMoedaInvalidoException extends RuntimeException {
    public NomeMoedaInvalidoException() {
        super("A moeda deve possuir um nome");
    }
}
