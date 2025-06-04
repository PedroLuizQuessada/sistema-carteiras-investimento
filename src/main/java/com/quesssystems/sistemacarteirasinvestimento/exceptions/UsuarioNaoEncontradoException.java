package com.quesssystems.sistemacarteirasinvestimento.exceptions;

public class UsuarioNaoEncontradoException extends RuntimeException {
    public UsuarioNaoEncontradoException(String id) {
        super(String.format("Usuário de ID %s não encontrado", id));
    }
}
