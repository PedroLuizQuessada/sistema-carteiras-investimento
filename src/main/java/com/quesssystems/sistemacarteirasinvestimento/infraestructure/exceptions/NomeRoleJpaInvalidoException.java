package com.quesssystems.sistemacarteirasinvestimento.infraestructure.exceptions;

public class NomeRoleJpaInvalidoException extends RuntimeException {
    public NomeRoleJpaInvalidoException() {
        super("A role deve possuir um nome para ser armazenada no banco de dados");
    }

    public NomeRoleJpaInvalidoException(int numeroMaximoCaracteres) {
        super(String.format("O nome da role deve possuir no máximo %d caracteres para ser armazenado no banco de dados", numeroMaximoCaracteres));
    }
}
