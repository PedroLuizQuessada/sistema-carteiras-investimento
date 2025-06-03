package com.quesssystems.sistemacarteirasinvestimento.entities;

public class Acao {
    private final String id;
    private final String nome;
    private final String origem;

    public Acao(String id, String nome, String origem) {
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
}
