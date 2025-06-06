package com.quesssystems.sistemacarteirasinvestimento.datasources;

import com.quesssystems.sistemacarteirasinvestimento.dtos.CarteiraDto;

import java.util.List;
import java.util.Optional;

public interface CarteiraDataSource {
    CarteiraDto criarCarteira(CarteiraDto criarCarteiraDto);
    Optional<CarteiraDto> consultarCarteiraPorId(String id);
    void removerCarteira(CarteiraDto carteiraDto);
    List<CarteiraDto> consultarCarteirasPorUsuarioId(String usuarioId);
}
