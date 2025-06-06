package com.quesssystems.sistemacarteirasinvestimento.infraestructure.exceptions;

public class SenhaUsuarioJpaInvalidaException extends RuntimeException {
    public SenhaUsuarioJpaInvalidaException() {
        super("O usuário deve possuir uma senha para ser armazenado no banco de dados");
    }

    public SenhaUsuarioJpaInvalidaException(int numeroMaximoCaracteres) {
        super(String.format("A senha do usuário deve possuir no máximo %d caracteres para ser armazenada no banco de dados", numeroMaximoCaracteres));
    }
}
