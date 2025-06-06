package com.quesssystems.sistemacarteirasinvestimento.exceptions;

public class EmailUsuarioInvalidoException extends RuntimeException {

  public EmailUsuarioInvalidoException() {
    super("O usuário deve possuir um e-mail");
  }

  public EmailUsuarioInvalidoException(String email) {
        super(String.format("E-mail %s inválido para usuário", email));
  }
}
