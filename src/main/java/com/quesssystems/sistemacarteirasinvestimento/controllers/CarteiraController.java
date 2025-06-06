package com.quesssystems.sistemacarteirasinvestimento.controllers;

import com.quesssystems.sistemacarteirasinvestimento.datasources.AcaoDataSource;
import com.quesssystems.sistemacarteirasinvestimento.datasources.CarteiraDataSource;
import com.quesssystems.sistemacarteirasinvestimento.datasources.MoedaDataSource;
import com.quesssystems.sistemacarteirasinvestimento.datasources.UsuarioDataSource;
import com.quesssystems.sistemacarteirasinvestimento.dtos.requests.CriarCarteiraDto;
import com.quesssystems.sistemacarteirasinvestimento.dtos.responses.AcaoDtoResponse;
import com.quesssystems.sistemacarteirasinvestimento.dtos.responses.CarteiraDtoResponse;
import com.quesssystems.sistemacarteirasinvestimento.dtos.responses.MoedaDtoResponse;
import com.quesssystems.sistemacarteirasinvestimento.entities.Acao;
import com.quesssystems.sistemacarteirasinvestimento.entities.Carteira;
import com.quesssystems.sistemacarteirasinvestimento.entities.Moeda;
import com.quesssystems.sistemacarteirasinvestimento.gateways.AcaoGateway;
import com.quesssystems.sistemacarteirasinvestimento.gateways.CarteiraGateway;
import com.quesssystems.sistemacarteirasinvestimento.gateways.MoedaGateway;
import com.quesssystems.sistemacarteirasinvestimento.gateways.UsuarioGateway;
import com.quesssystems.sistemacarteirasinvestimento.presenters.AcaoPresenter;
import com.quesssystems.sistemacarteirasinvestimento.presenters.CarteiraPresenter;
import com.quesssystems.sistemacarteirasinvestimento.presenters.MoedaPresenter;
import com.quesssystems.sistemacarteirasinvestimento.usecases.*;

import java.util.List;

public class CarteiraController {

    private final CarteiraDataSource carteiraDataSource;
    private final UsuarioDataSource usuarioDataSource;
    private final AcaoDataSource acaoDataSource;
    private final MoedaDataSource moedaDataSource;

    public CarteiraController(CarteiraDataSource carteiraDataSource,
                              UsuarioDataSource usuarioDataSource,
                              AcaoDataSource acaoDataSource,
                              MoedaDataSource moedaDataSource) {
        this.carteiraDataSource = carteiraDataSource;
        this.usuarioDataSource = usuarioDataSource;
        this.acaoDataSource = acaoDataSource;
        this.moedaDataSource = moedaDataSource;
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
        CarteiraGateway carteiraGateway = new CarteiraGateway(this.carteiraDataSource);
        UsuarioGateway usuarioGateway = new UsuarioGateway(this.usuarioDataSource);
        AcaoGateway acaoGateway = new AcaoGateway(this.acaoDataSource);
        MoedaGateway moedaGateway = new MoedaGateway(this.moedaDataSource);
        CriarCarteiraUseCase useCase = new CriarCarteiraUseCase(carteiraGateway, usuarioGateway, acaoGateway, moedaGateway);
        Carteira carteira = useCase.executar(criarCarteiraDto);
        return CarteiraPresenter.toResponse(carteira);
    }

    public void removerCarteira(String id) {
        CarteiraGateway gateway = new CarteiraGateway(this.carteiraDataSource);
        RemoverCarteiraUseCase useCase = new RemoverCarteiraUseCase(gateway);
        useCase.executar(id);
    }
}
