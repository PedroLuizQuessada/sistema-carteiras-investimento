package com.quesssystems.sistemacarteirasinvestimento.presenters;

import com.quesssystems.sistemacarteirasinvestimento.dtos.responses.RoleDtoResponse;
import com.quesssystems.sistemacarteirasinvestimento.dtos.responses.UsuarioDataDtoResponse;
import com.quesssystems.sistemacarteirasinvestimento.dtos.responses.UsuarioDtoResponse;
import com.quesssystems.sistemacarteirasinvestimento.entities.Usuario;

public class UsuarioPresenter {

    public static UsuarioDtoResponse toResponse(Usuario usuario) {
        return new UsuarioDtoResponse(usuario.getEmail());
    }

    public static UsuarioDataDtoResponse toDataResponse(Usuario usuario) {
        return new UsuarioDataDtoResponse(usuario.getEmail(), usuario.getSenha(),
                usuario.getRoleList().stream().map(role -> new RoleDtoResponse(role.getNome())).toList());
    }
}
