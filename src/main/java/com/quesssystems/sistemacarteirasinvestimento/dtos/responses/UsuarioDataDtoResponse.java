package com.quesssystems.sistemacarteirasinvestimento.dtos.responses;

import java.util.List;

public record UsuarioDataDtoResponse(String email, String senha, List<RoleDtoResponse> roleDtoResponseList) {
}
