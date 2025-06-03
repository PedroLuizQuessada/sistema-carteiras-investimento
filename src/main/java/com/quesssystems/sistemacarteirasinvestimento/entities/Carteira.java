package com.quesssystems.sistemacarteirasinvestimento.entities;

import com.quesssystems.sistemacarteirasinvestimento.exceptions.NumeroAcoesEstrangeirasException;
import com.quesssystems.sistemacarteirasinvestimento.exceptions.NumeroAcoesException;
import com.quesssystems.sistemacarteirasinvestimento.exceptions.NumeroMoedasException;

import java.util.List;

public class Carteira {
    private final String id;
    private final Usuario usuario;
    private final List<Acao> acaoList;
    private final List<Moeda> moedaList;

    public Carteira(String id, Usuario usuario, List<Acao> acaoList, List<Moeda> moedaList) {
        validarNumeroAcoes(acaoList);
        validarNumeroAcoesEstrangeiras(acaoList);
        validarNumeroMoeda(moedaList);

        this.id = id;
        this.usuario = usuario;
        this.acaoList = acaoList;
        this.moedaList = moedaList;
    }

    public String getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public List<Acao> getAcaoList() {
        return acaoList;
    }

    public List<Moeda> getMoedaList() {
        return moedaList;
    }

    private void validarNumeroAcoes(List<Acao> acaoList) {
        int numeroMaximoAcoes = 10;
        if (acaoList.size() > numeroMaximoAcoes) {
            throw new NumeroAcoesException(acaoList.size(), numeroMaximoAcoes);
        }
    }

    private void validarNumeroAcoesEstrangeiras(List<Acao> acaoList) {
        int numeroMaximoAcoesEstrangeiras = 3;
        int numeroAcoesEstrangeiras = 0;
        for (Acao acao : acaoList) {
            if (!acao.getOrigem().equalsIgnoreCase("BR")) {
                numeroAcoesEstrangeiras += 1;
            }

            if (numeroAcoesEstrangeiras > numeroMaximoAcoesEstrangeiras) {
                throw new NumeroAcoesEstrangeirasException(numeroAcoesEstrangeiras, numeroMaximoAcoesEstrangeiras);
            }
        }
    }

    private void validarNumeroMoeda(List<Moeda> moedaList) {
        int numeroMaximoMoedas = 3;
        if (moedaList.size() > numeroMaximoMoedas) {
            throw new NumeroMoedasException(moedaList.size(), numeroMaximoMoedas);
        }
    }
}
