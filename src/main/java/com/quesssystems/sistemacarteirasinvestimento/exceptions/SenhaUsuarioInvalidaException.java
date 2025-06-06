package com.quesssystems.sistemacarteirasinvestimento.exceptions;

public class SenhaUsuarioInvalidaException extends RuntimeException {

    public SenhaUsuarioInvalidaException() {
        super("O usuário deve possuir uma senha");
    }

    public SenhaUsuarioInvalidaException(int numeroCaracteres) {
        super(String.format("A senha deve possuir pelo menos %d caracteres", numeroCaracteres));
    }
}
