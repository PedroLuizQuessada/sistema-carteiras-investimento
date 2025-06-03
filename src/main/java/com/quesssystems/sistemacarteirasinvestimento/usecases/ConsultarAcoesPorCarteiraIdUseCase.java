package com.quesssystems.sistemacarteirasinvestimento.usecases;

import com.quesssystems.sistemacarteirasinvestimento.entities.Acao;
import com.quesssystems.sistemacarteirasinvestimento.entities.Carteira;
import com.quesssystems.sistemacarteirasinvestimento.gateways.CarteiraGateway;

import java.util.List;

public class ConsultarAcoesPorCarteiraIdUseCase {

    private final CarteiraGateway carteiraGateway;

    public ConsultarAcoesPorCarteiraIdUseCase(CarteiraGateway carteiraGateway) {
        this.carteiraGateway = carteiraGateway;
    }

    public List<Acao> executar(String carteiraId) {
        Carteira carteira = carteiraGateway.consultarCarteiraPorId(carteiraId);
        return carteira.getAcaoList();
    }
}
