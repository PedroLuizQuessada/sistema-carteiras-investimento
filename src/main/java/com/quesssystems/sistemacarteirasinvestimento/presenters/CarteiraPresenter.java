package com.quesssystems.sistemacarteirasinvestimento.presenters;

import com.quesssystems.sistemacarteirasinvestimento.dtos.responses.CarteiraDtoResponse;
import com.quesssystems.sistemacarteirasinvestimento.entities.Carteira;

public class CarteiraPresenter {

    public static CarteiraDtoResponse toResponse(Carteira carteira) {
        return new CarteiraDtoResponse(UsuarioPresenter.toResponse(carteira.getUsuario()),
                carteira.getAcaoList().stream().map(AcaoPresenter::toResponse).toList(),
                carteira.getMoedaList().stream().map(MoedaPresenter::toResponse).toList());
    }
}
