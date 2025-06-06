package com.quesssystems.sistemacarteirasinvestimento.infraestructure.exceptions;

public class OrigemAcaoJpaInvalidaException extends RuntimeException {
    public OrigemAcaoJpaInvalidaException() {
        super("A ação deve possuir uma origem para ser armazenada no banco de dados");
    }

    public OrigemAcaoJpaInvalidaException(int numeroMaximoCaracteres) {
        super(String.format("A origem da ação deve possuir no máximo %d caracteres para ser armazenada no banco de dados", numeroMaximoCaracteres));
    }
}
