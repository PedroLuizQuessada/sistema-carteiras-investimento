package com.quesssystems.sistemacarteirasinvestimento.controllers;

import com.quesssystems.sistemacarteirasinvestimento.datasources.CarteiraDataSource;
import com.quesssystems.sistemacarteirasinvestimento.dtos.CriarCarteiraDto;
import com.quesssystems.sistemacarteirasinvestimento.dtos.responses.AcaoDtoResponse;
import com.quesssystems.sistemacarteirasinvestimento.dtos.responses.CarteiraDtoResponse;
import com.quesssystems.sistemacarteirasinvestimento.dtos.responses.MoedaDtoResponse;
import com.quesssystems.sistemacarteirasinvestimento.entities.Acao;
import com.quesssystems.sistemacarteirasinvestimento.entities.Carteira;
import com.quesssystems.sistemacarteirasinvestimento.entities.Moeda;
import com.quesssystems.sistemacarteirasinvestimento.gateways.CarteiraGateway;
import com.quesssystems.sistemacarteirasinvestimento.presenters.AcaoPresenter;
import com.quesssystems.sistemacarteirasinvestimento.presenters.CarteiraPresenter;
import com.quesssystems.sistemacarteirasinvestimento.presenters.MoedaPresenter;
import com.quesssystems.sistemacarteirasinvestimento.usecases.*;

import java.util.List;

public class CarteiraController {

    private final CarteiraDataSource carteiraDataSource;

    public CarteiraController(CarteiraDataSource carteiraDataSource) {
        this.carteiraDataSource = carteiraDataSource;
    }

    public List<AcaoDtoResponse> consultarAcoesPorCarteiraId(String carteiraId) {
        CarteiraGateway gateway = new CarteiraGateway(this.carteiraDataSource);
        ConsultarAcoesPorCarteiraIdUseCase useCase = new ConsultarAcoesPorCarteiraIdUseCase(gateway);
        List<Acao> acaoList = useCase.executar(carteiraId);
        return acaoList.stream().map(AcaoPresenter::toResponse).toList();
    }

    public List<CarteiraDtoResponse> consultarCarteirasPorUsuarioId(String usuarioId) {
        CarteiraGateway gateway = new CarteiraGateway(this.carteiraDataSource);
        ConsultarCarteirasPorUsuarioIdUseCase useCase = new ConsultarCarteirasPorUsuarioIdUseCase(gateway);
        List<Carteira> carteiraList = useCase.executar(usuarioId);
        return carteiraList.stream().map(CarteiraPresenter::toResponse).toList();
    }

    public CarteiraDtoResponse consultarCarteira(String carteiraId) {
        CarteiraGateway gateway = new CarteiraGateway(this.carteiraDataSource);
        ConsultarCarteiraUseCase useCase = new ConsultarCarteiraUseCase(gateway);
        Carteira carteira = useCase.executar(carteiraId);
        return CarteiraPresenter.toResponse(carteira);
    }

    public List<MoedaDtoResponse> consultarMoedasPorCarteiraId(String carteiraId) {
        CarteiraGateway gateway = new CarteiraGateway(this.carteiraDataSource);
        ConsultarMoedasPorCarteiraIdUseCase useCase = new ConsultarMoedasPorCarteiraIdUseCase(gateway);
        List<Moeda> moedaList = useCase.executar(carteiraId);
        return moedaList.stream().map(MoedaPresenter::toResponse).toList();
    }

    public CarteiraDtoResponse criarCarteira(CriarCarteiraDto criarCarteiraDto) {
        CarteiraGateway gateway = new CarteiraGateway(this.carteiraDataSource);
        CriarCarteiraUseCase useCase = new CriarCarteiraUseCase(gateway);
        Carteira carteira = useCase.executar(criarCarteiraDto);
        return CarteiraPresenter.toResponse(carteira);
    }

    public void removerCarteira(String id) {
        CarteiraGateway gateway = new CarteiraGateway(this.carteiraDataSource);
        RemoverCarteiraUseCase useCase = new RemoverCarteiraUseCase(gateway);
        useCase.executar(id);
    }
}
