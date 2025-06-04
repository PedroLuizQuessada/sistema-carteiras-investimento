package com.quesssystems.sistemacarteirasinvestimento.datasources;

import com.quesssystems.sistemacarteirasinvestimento.dtos.AcaoDto;

import java.util.Optional;

public interface AcaoDataSource {
    Optional<AcaoDto> consultarAcaoPorId(String id);
}
