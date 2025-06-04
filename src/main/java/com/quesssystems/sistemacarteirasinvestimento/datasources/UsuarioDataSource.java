package com.quesssystems.sistemacarteirasinvestimento.datasources;

import com.quesssystems.sistemacarteirasinvestimento.dtos.UsuarioDto;

import java.util.Optional;

public interface UsuarioDataSource {
    Optional<UsuarioDto> consultarUsuarioPorId(String id);
}
