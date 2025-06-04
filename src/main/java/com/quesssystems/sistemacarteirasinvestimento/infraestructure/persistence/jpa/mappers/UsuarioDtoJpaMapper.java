package com.quesssystems.sistemacarteirasinvestimento.infraestructure.persistence.jpa.mappers;

import com.quesssystems.sistemacarteirasinvestimento.dtos.UsuarioDto;
import com.quesssystems.sistemacarteirasinvestimento.infraestructure.persistence.jpa.model.UsuarioJpa;
import org.springframework.stereotype.Component;

@Component
public class UsuarioDtoJpaMapper {

    public UsuarioDto toUsuarioDto(UsuarioJpa usuarioJpa) {
        return new UsuarioDto(String.valueOf(usuarioJpa.getId()), usuarioJpa.getEmail(), usuarioJpa.getSenha());
    }

    public UsuarioJpa toUsuarioJpa(UsuarioDto usuarioDto) {
        return new UsuarioJpa(Long.valueOf(usuarioDto.id()), usuarioDto.email(), usuarioDto.senha());
    }
}
