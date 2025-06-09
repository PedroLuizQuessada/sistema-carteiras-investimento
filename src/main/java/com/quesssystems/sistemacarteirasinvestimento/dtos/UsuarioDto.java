package com.quesssystems.sistemacarteirasinvestimento.dtos;

import java.util.List;

public record UsuarioDto(String id, String email, String senha, List<RoleDto> roleDtoList) {
}
