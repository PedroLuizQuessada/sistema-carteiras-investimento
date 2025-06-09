package com.quesssystems.sistemacarteirasinvestimento.exceptions;

public class NomeRoleInvalidoException extends RuntimeException {

    public NomeRoleInvalidoException() {
      super("A role deve possuir um nome");
    }
}
