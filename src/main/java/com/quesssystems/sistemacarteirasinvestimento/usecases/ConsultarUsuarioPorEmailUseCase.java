package com.quesssystems.sistemacarteirasinvestimento.usecases;

import com.quesssystems.sistemacarteirasinvestimento.entities.Usuario;
import com.quesssystems.sistemacarteirasinvestimento.gateways.UsuarioGateway;

public class ConsultarUsuarioPorEmailUseCase {

    private final UsuarioGateway usuarioGateway;

    public ConsultarUsuarioPorEmailUseCase(UsuarioGateway usuarioGateway) {
        this.usuarioGateway = usuarioGateway;
    }

    public Usuario executar(String email) {
        return usuarioGateway.consultarUsuarioPorEmail(email);
    }
}
