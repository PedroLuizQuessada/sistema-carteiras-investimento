package com.quesssystems.sistemacarteirasinvestimento.exceptions;

public class MoedaNaoEncontradaException extends RuntimeException {
    public MoedaNaoEncontradaException(String id) {
        super(String.format("Moeda de ID %s não encontrada", id));
    }
}
