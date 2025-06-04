package com.quesssystems.sistemacarteirasinvestimento.usecases;

import com.quesssystems.sistemacarteirasinvestimento.dtos.CriarCarteiraDto;
import com.quesssystems.sistemacarteirasinvestimento.entities.Carteira;
import com.quesssystems.sistemacarteirasinvestimento.gateways.AcaoGateway;
import com.quesssystems.sistemacarteirasinvestimento.gateways.CarteiraGateway;
import com.quesssystems.sistemacarteirasinvestimento.gateways.MoedaGateway;
import com.quesssystems.sistemacarteirasinvestimento.gateways.UsuarioGateway;

public class CriarCarteiraUseCase {

    private final CarteiraGateway carteiraGateway;
    private final UsuarioGateway usuarioGateway;
    private final AcaoGateway acaoGateway;
    private final MoedaGateway moedaGateway;

    public CriarCarteiraUseCase(CarteiraGateway carteiraGateway, UsuarioGateway usuarioGateway, AcaoGateway acaoGateway, MoedaGateway moedaGateway) {
        this.carteiraGateway = carteiraGateway;
        this.usuarioGateway = usuarioGateway;
        this.acaoGateway = acaoGateway;
        this.moedaGateway = moedaGateway;
    }

    public Carteira executar(CriarCarteiraDto criarCarteiraDto) {
        usuarioGateway.consultarUsuarioPorId(criarCarteiraDto.usuarioDto().id());
        criarCarteiraDto.acaoDtoList().forEach(acaoDto -> acaoGateway.consultarAcaoPorId(acaoDto.id()));
        criarCarteiraDto.moedaDtoList().forEach(moedaDto -> moedaGateway.consultarMoedaPorId(moedaDto.id()));
        return carteiraGateway.criarCarteira(criarCarteiraDto);
    }
}
