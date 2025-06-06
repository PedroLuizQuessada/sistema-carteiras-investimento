package com.quesssystems.sistemacarteirasinvestimento.infraestructure.exceptions;

public class NomeMoedaJpaInvalidoException extends RuntimeException {
    public NomeMoedaJpaInvalidoException() {
        super("A moeda deve possuir um nome para ser armazenada no banco de dados");
    }

    public NomeMoedaJpaInvalidoException(int numeroMaximoCaracteres) {
        super(String.format("O nome da moeda deve possuir no máximo %d caracteres para ser armazenado no banco de dados", numeroMaximoCaracteres));
    }
}
