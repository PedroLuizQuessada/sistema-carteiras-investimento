package com.quesssystems.sistemacarteirasinvestimento.dtos.requests;

import java.util.List;

public record CriarCarteiraDto(String usuarioId, List<String> acaoDtoList, List<String> moedaDtoList) {
}
