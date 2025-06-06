package com.quesssystems.sistemacarteirasinvestimento.infraestructure.exceptions;

public class EmailUsuarioJpaInvalidoException extends RuntimeException {
    public EmailUsuarioJpaInvalidoException() {
      super("O usuário deve possuir um e-mail para ser armazenado no banco de dados");
    }

  public EmailUsuarioJpaInvalidoException(int numeroMaximoCaracteres) {
    super(String.format("O e-mail do usuário deve possuir no máximo %d caracteres para ser armazenado no banco de dados", numeroMaximoCaracteres));
  }
}
