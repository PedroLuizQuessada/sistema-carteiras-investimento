package com.quesssystems.sistemacarteirasinvestimento.entities;

public class Moeda {
    private final String id;
    private final String nome;

    public Moeda(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
