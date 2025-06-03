package com.quesssystems.sistemacarteirasinvestimento.dtos;

import java.util.List;

public record CriarCarteiraDto(UsuarioDto usuarioDto, List<AcaoDto> acaoDtoList, List<MoedaDto> moedaDtoList) {
}
