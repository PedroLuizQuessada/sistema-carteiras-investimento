package com.quesssystems.sistemacarteirasinvestimento.entities;

public class Usuario {
    private final String id;
    private final String email;
    private final String senha;

    public Usuario(String id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
