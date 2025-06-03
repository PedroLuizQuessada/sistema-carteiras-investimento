package com.quesssystems.sistemacarteirasinvestimento.dtos.responses;

import java.util.List;

public record CarteiraDtoResponse(UsuarioDtoResponse usuarioDtoResponse,
                                  List<AcaoDtoResponse> acaoDtoResponseList,
                                  List<MoedaDtoResponse> moedaDtoResponseList) {
}
