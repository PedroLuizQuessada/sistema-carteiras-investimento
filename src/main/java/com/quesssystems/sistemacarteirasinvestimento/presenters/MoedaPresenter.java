package com.quesssystems.sistemacarteirasinvestimento.presenters;

import com.quesssystems.sistemacarteirasinvestimento.dtos.responses.MoedaDtoResponse;
import com.quesssystems.sistemacarteirasinvestimento.entities.Moeda;

public class MoedaPresenter {

    public static MoedaDtoResponse toResponse(Moeda moeda) {
        return new MoedaDtoResponse(moeda.getNome(), moeda.getSimbolo());
    }
}
