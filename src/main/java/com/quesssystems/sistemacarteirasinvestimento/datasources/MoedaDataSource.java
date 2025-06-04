package com.quesssystems.sistemacarteirasinvestimento.datasources;

import com.quesssystems.sistemacarteirasinvestimento.dtos.MoedaDto;

import java.util.Optional;

public interface MoedaDataSource {
    Optional<MoedaDto> consultarMoedaPorId(String id);
}
