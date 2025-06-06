package com.quesssystems.sistemacarteirasinvestimento.entities;

import com.quesssystems.sistemacarteirasinvestimento.exceptions.NomeMoedaException;

import java.util.Objects;

public class Moeda {
    private final String id;
    private final String nome;

    public Moeda(String id, String nome) {
        validarNome(nome);

        this.id = id;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    private void validarNome(String nome) {
        if (Objects.isNull(nome))
            throw new NomeMoedaException();
    }
}
