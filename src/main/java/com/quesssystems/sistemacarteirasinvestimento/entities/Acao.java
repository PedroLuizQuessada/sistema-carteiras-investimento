package com.quesssystems.sistemacarteirasinvestimento.entities;

import com.quesssystems.sistemacarteirasinvestimento.exceptions.NomeAcaoInvalidoException;
import com.quesssystems.sistemacarteirasinvestimento.exceptions.OrigemAcaoInvalidaException;

import java.util.Objects;

public class Acao {
    private final String id;
    private final String nome;
    private final String origem;

    public Acao(String id, String nome, String origem) {
        validarNome(nome);
        validarOrigem(origem);

        this.id = id;
        this.nome = nome;
        this.origem = origem;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getOrigem() {
        return origem;
    }

    private void validarNome(String nome) {
        if (Objects.isNull(nome))
            throw new NomeAcaoInvalidoException();
    }

    private void validarOrigem(String origem) {
        if (Objects.isNull(origem))
            throw new OrigemAcaoInvalidaException();
    }
}
