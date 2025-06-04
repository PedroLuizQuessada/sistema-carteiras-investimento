package com.quesssystems.sistemacarteirasinvestimento.exceptions;

public class AcaoNaoEncontradaException extends RuntimeException {
    public AcaoNaoEncontradaException(String id) {
        super(String.format("Ação de ID %s não encontrada", id));
    }
}
