package com.quesssystems.sistemacarteirasinvestimento.usecases;

import com.quesssystems.sistemacarteirasinvestimento.entities.Carteira;
import com.quesssystems.sistemacarteirasinvestimento.entities.Moeda;
import com.quesssystems.sistemacarteirasinvestimento.gateways.CarteiraGateway;

import java.util.List;

public class ConsultarMoedasPorCarteiraIdUseCase {

    private final CarteiraGateway carteiraGateway;

    public ConsultarMoedasPorCarteiraIdUseCase(CarteiraGateway carteiraGateway) {
        this.carteiraGateway = carteiraGateway;
    }

    public List<Moeda> executar(String carteiraId) {
        Carteira carteira = carteiraGateway.consultarCarteiraPorId(carteiraId);
        return carteira.getMoedaList();
    }
}
