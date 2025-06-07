package com.quesssystems.sistemacarteirasinvestimento.infraestructure.exceptions;

public class SimboloMoedaJpaInvalidoException extends RuntimeException {
    public SimboloMoedaJpaInvalidoException() {
      super("A moeda deve possuir um símbolo para ser armazenada no banco de dados");
    }

    public SimboloMoedaJpaInvalidoException(int numeroMaximoCaracteres) {
      super(String.format("O símbolo da moeda deve possuir no máximo %d caracteres para ser armazenado no banco de dados", numeroMaximoCaracteres));
    }
}
