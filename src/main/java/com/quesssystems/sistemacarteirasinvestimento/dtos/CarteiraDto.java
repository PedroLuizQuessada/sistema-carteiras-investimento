package com.quesssystems.sistemacarteirasinvestimento.dtos;

import java.util.List;

public record CarteiraDto(String id, UsuarioDto usuarioDto, List<AcaoDto> acaoDtoList, List<MoedaDto> moedaDtoList) {
}
