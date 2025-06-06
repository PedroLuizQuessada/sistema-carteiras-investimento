package com.quesssystems.sistemacarteirasinvestimento.exceptions;

public class SenhaUsuarioException extends RuntimeException {

    public SenhaUsuarioException() {
        super("O usuário deve possuir uma senha");
    }

    public SenhaUsuarioException(int numeroCaracteres) {
        super(String.format("A senha deve possuir pelo menos %d caracteres", numeroCaracteres));
    }
}
