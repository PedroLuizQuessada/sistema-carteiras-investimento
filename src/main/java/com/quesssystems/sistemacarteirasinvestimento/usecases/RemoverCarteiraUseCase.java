package com.quesssystems.sistemacarteirasinvestimento.usecases;

import com.quesssystems.sistemacarteirasinvestimento.entities.Carteira;
import com.quesssystems.sistemacarteirasinvestimento.gateways.CarteiraGateway;

public class RemoverCarteiraUseCase {

    private final CarteiraGateway carteiraGateway;

    public RemoverCarteiraUseCase(CarteiraGateway carteiraGateway) {
        this.carteiraGateway = carteiraGateway;
    }

    public void executar(String id) {
        Carteira carteira = carteiraGateway.consultarCarteiraPorId(id);
        carteiraGateway.removerCarteira(carteira);
    }
}
