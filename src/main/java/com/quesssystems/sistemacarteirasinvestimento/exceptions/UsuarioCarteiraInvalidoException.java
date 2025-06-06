package com.quesssystems.sistemacarteirasinvestimento.exceptions;

public class UsuarioCarteiraInvalidoException extends RuntimeException {
    public UsuarioCarteiraInvalidoException() {
        super("A carteira deve possuir um usuário");
    }
}
