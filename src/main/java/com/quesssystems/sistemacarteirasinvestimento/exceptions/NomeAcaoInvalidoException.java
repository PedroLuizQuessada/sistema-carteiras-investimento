package com.quesssystems.sistemacarteirasinvestimento.exceptions;

public class NomeAcaoInvalidoException extends RuntimeException {

    public NomeAcaoInvalidoException() {
      super("A ação deve possuir um nome");
    }
}
