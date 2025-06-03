package com.quesssystems.sistemacarteirasinvestimento.usecases;

import com.quesssystems.sistemacarteirasinvestimento.dtos.CriarCarteiraDto;
import com.quesssystems.sistemacarteirasinvestimento.entities.Carteira;
import com.quesssystems.sistemacarteirasinvestimento.gateways.CarteiraGateway;

public class CriarCarteiraUseCase {

    private final CarteiraGateway carteiraGateway;

    public CriarCarteiraUseCase(CarteiraGateway carteiraGateway) {
        this.carteiraGateway = carteiraGateway;
    }

    public Carteira executar(CriarCarteiraDto criarCarteiraDto) {
        return carteiraGateway.criarCarteira(criarCarteiraDto);
    }
}
