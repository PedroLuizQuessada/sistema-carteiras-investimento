package com.quesssystems.sistemacarteirasinvestimento.presenters;

import com.quesssystems.sistemacarteirasinvestimento.dtos.responses.AcaoDtoResponse;
import com.quesssystems.sistemacarteirasinvestimento.entities.Acao;

public class AcaoPresenter {

    public static AcaoDtoResponse toResponse(Acao acao) {
        return new AcaoDtoResponse(acao.getNome(), acao.getOrigem());
    }
}
