package com.quesssystems.sistemacarteirasinvestimento.gateways;

import com.quesssystems.sistemacarteirasinvestimento.datasources.UsuarioDataSource;
import com.quesssystems.sistemacarteirasinvestimento.dtos.UsuarioDto;
import com.quesssystems.sistemacarteirasinvestimento.entities.Usuario;
import com.quesssystems.sistemacarteirasinvestimento.exceptions.UsuarioNaoEncontradoException;

import java.util.Optional;

public class UsuarioGateway {

    private final UsuarioDataSource usuarioDataSource;

    public UsuarioGateway(UsuarioDataSource usuarioDataSource) {
        this.usuarioDataSource = usuarioDataSource;
    }

    public Usuario consultarUsuarioPorId(String id) {
        Optional<UsuarioDto> usuarioDtoOptional = usuarioDataSource.consultarUsuarioPorId(id);

        if (usuarioDtoOptional.isEmpty())
            throw new UsuarioNaoEncontradoException(id);

        UsuarioDto usuarioDto = usuarioDtoOptional.get();
        return criarEntidade(usuarioDto);
    }

    private Usuario criarEntidade(UsuarioDto usuarioDto) {
        return new Usuario(usuarioDto.id(), usuarioDto.email(), usuarioDto.senha());
    }
}
