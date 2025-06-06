package com.quesssystems.sistemacarteirasinvestimento.infraestructure.exceptions;

public class NomeAcaoJpaInvalidoException extends RuntimeException {
    public NomeAcaoJpaInvalidoException() {
        super("A ação deve possuir um nome para ser armazenada no banco de dados");
    }

    public NomeAcaoJpaInvalidoException(int numeroMaximoCaracteres) {
        super(String.format("O nome da ação deve possuir no máximo %d caracteres para ser armazenado no banco de dados", numeroMaximoCaracteres));
    }
}
