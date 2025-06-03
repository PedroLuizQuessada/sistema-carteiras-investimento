package com.quesssystems.sistemacarteirasinvestimento.exceptions;

public class CarteiraNaoEncontradaException extends RuntimeException {
    public CarteiraNaoEncontradaException(String id) {
        super(String.format("Carteira de ID %s não encontrada", id));
    }
}
