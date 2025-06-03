package com.quesssystems.sistemacarteirasinvestimento.presenters;

import com.quesssystems.sistemacarteirasinvestimento.dtos.responses.UsuarioDtoResponse;
import com.quesssystems.sistemacarteirasinvestimento.entities.Usuario;

public class UsuarioPresenter {

    public static UsuarioDtoResponse toResponse(Usuario usuario) {
        return new UsuarioDtoResponse(usuario.getEmail());
    }
}
