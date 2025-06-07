package com.quesssystems.sistemacarteirasinvestimento.entities;

import com.quesssystems.sistemacarteirasinvestimento.exceptions.NomeMoedaInvalidoException;
import com.quesssystems.sistemacarteirasinvestimento.exceptions.SimboloMoedaInvalidoException;

import java.util.Objects;

public class Moeda {
    private final String id;
    private final String nome;
    private final String simbolo;

    public Moeda(String id, String nome, String simbolo) {
        validarNome(nome);
        validarSimbolo(simbolo);

        this.id = id;
        this.nome = nome;
        this.simbolo = simbolo;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSimbolo() {
        return simbolo;
    }

    private void validarNome(String nome) {
        if (Objects.isNull(nome))
            throw new NomeMoedaInvalidoException();
    }

    private void validarSimbolo(String simbolo) {
        if (Objects.isNull(simbolo))
            throw new SimboloMoedaInvalidoException();
    }
}
