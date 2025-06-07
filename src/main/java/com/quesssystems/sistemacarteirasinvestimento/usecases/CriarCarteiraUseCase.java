package com.quesssystems.sistemacarteirasinvestimento.usecases;

import com.quesssystems.sistemacarteirasinvestimento.dtos.*;
import com.quesssystems.sistemacarteirasinvestimento.dtos.requests.CriarCarteiraDto;
import com.quesssystems.sistemacarteirasinvestimento.entities.Acao;
import com.quesssystems.sistemacarteirasinvestimento.entities.Carteira;
import com.quesssystems.sistemacarteirasinvestimento.entities.Moeda;
import com.quesssystems.sistemacarteirasinvestimento.entities.Usuario;
import com.quesssystems.sistemacarteirasinvestimento.gateways.AcaoGateway;
import com.quesssystems.sistemacarteirasinvestimento.gateways.CarteiraGateway;
import com.quesssystems.sistemacarteirasinvestimento.gateways.MoedaGateway;
import com.quesssystems.sistemacarteirasinvestimento.gateways.UsuarioGateway;

import java.util.List;

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
        Usuario usuario = usuarioGateway.consultarUsuarioPorId(criarCarteiraDto.usuarioId());
        List<Acao> acaoList = criarCarteiraDto.acaoDtoList().stream().map(acaoGateway::consultarAcaoPorId).toList();
        List<Moeda> moedaList = criarCarteiraDto.moedaDtoList().stream().map(moedaGateway::consultarMoedaPorId).toList();
        return carteiraGateway.criarCarteira(new CarteiraDto(null,
                new UsuarioDto(usuario.getId(), usuario.getEmail(), usuario.getSenha()),
                acaoList.stream().map(acao -> new AcaoDto(acao.getId(), acao.getNome(), acao.getOrigem())).toList(),
                moedaList.stream().map(moeda -> new MoedaDto(moeda.getId(), moeda.getNome(), moeda.getSimbolo())).toList()));
    }
}
