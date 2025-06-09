package com.quesssystems.sistemacarteirasinvestimento.entities;

import com.quesssystems.sistemacarteirasinvestimento.exceptions.NomeRoleInvalidoException;

import java.util.Objects;

public class Role {
    private final String id;
    private final String nome;

    public Role(String id, String nome) {
        validarNome(nome);

        this.id = id;
        this.nome = nome;
    }

    private void validarNome(String nome) {
        if (Objects.isNull(nome))
            throw new NomeRoleInvalidoException();
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
