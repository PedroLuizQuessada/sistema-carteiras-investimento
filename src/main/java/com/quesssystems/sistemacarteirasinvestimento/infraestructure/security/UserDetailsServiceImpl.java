package com.quesssystems.sistemacarteirasinvestimento.infraestructure.security;

import com.quesssystems.sistemacarteirasinvestimento.controllers.UsuarioController;
import com.quesssystems.sistemacarteirasinvestimento.datasources.UsuarioDataSource;
import com.quesssystems.sistemacarteirasinvestimento.dtos.responses.UsuarioDataDtoResponse;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioController usuarioController;

    public UserDetailsServiceImpl(UsuarioDataSource usuarioDataSource) {
        this.usuarioController = new UsuarioController(usuarioDataSource);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        UsuarioDataDtoResponse usuario = usuarioController.consultarUsuarioPorEmail(username);
        return new org.springframework.security.core.userdetails.User(usuario.email(), usuario.senha(),
                usuario.roleDtoResponseList().stream().map(roleDtoResponse -> new SimpleGrantedAuthority(roleDtoResponse.nome())).toList());
    }
}
