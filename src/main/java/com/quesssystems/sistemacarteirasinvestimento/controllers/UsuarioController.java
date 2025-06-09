package com.quesssystems.sistemacarteirasinvestimento.controllers;

import com.quesssystems.sistemacarteirasinvestimento.datasources.UsuarioDataSource;
import com.quesssystems.sistemacarteirasinvestimento.dtos.responses.UsuarioDataDtoResponse;
import com.quesssystems.sistemacarteirasinvestimento.entities.Usuario;
import com.quesssystems.sistemacarteirasinvestimento.gateways.UsuarioGateway;
import com.quesssystems.sistemacarteirasinvestimento.presenters.UsuarioPresenter;
import com.quesssystems.sistemacarteirasinvestimento.usecases.ConsultarUsuarioPorEmailUseCase;

public class UsuarioController {

    private final UsuarioDataSource usuarioDataSource;

    public UsuarioController(UsuarioDataSource usuarioDataSource) {
        this.usuarioDataSource = usuarioDataSource;
    }

    public UsuarioDataDtoResponse consultarUsuarioPorEmail(String email) {
        UsuarioGateway gateway = new UsuarioGateway(this.usuarioDataSource);
        ConsultarUsuarioPorEmailUseCase useCase = new ConsultarUsuarioPorEmailUseCase(gateway);
        Usuario usuario = useCase.executar(email);
        return UsuarioPresenter.toDataResponse(usuario);
    }
}
