package com.quesssystems.sistemacarteirasinvestimento.exceptions;

public class UsuarioNaoEncontradoException extends RuntimeException {
    public UsuarioNaoEncontradoException(String campo, String id) {
        super(String.format("Usuário de %s %s não encontrado", campo, id));
    }
}
