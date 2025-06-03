package com.quesssystems.sistemacarteirasinvestimento.usecases;

import com.quesssystems.sistemacarteirasinvestimento.entities.Carteira;
import com.quesssystems.sistemacarteirasinvestimento.gateways.CarteiraGateway;

public class ConsultarCarteiraUseCase {

    private final CarteiraGateway carteiraGateway;

    public ConsultarCarteiraUseCase(CarteiraGateway carteiraGateway) {
        this.carteiraGateway = carteiraGateway;
    }

    public Carteira executar(String id) {
        return carteiraGateway.consultarCarteiraPorId(id);
    }
}
