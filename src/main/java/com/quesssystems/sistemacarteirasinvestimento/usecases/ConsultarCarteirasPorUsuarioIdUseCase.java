package com.quesssystems.sistemacarteirasinvestimento.usecases;

import com.quesssystems.sistemacarteirasinvestimento.entities.Carteira;
import com.quesssystems.sistemacarteirasinvestimento.gateways.CarteiraGateway;

import java.util.List;

public class ConsultarCarteirasPorUsuarioIdUseCase {

    private final CarteiraGateway carteiraGateway;

    public ConsultarCarteirasPorUsuarioIdUseCase(CarteiraGateway carteiraGateway) {
        this.carteiraGateway = carteiraGateway;
    }

    public List<Carteira> executar(String usuarioId) {
        return carteiraGateway.consultarCarteirasPorUsuarioId(usuarioId);
    }
}
