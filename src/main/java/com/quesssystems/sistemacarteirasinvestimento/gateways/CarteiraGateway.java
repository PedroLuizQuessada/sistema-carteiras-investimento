package com.quesssystems.sistemacarteirasinvestimento.gateways;

import com.quesssystems.sistemacarteirasinvestimento.datasources.CarteiraDataSource;
import com.quesssystems.sistemacarteirasinvestimento.dtos.*;
import com.quesssystems.sistemacarteirasinvestimento.entities.Acao;
import com.quesssystems.sistemacarteirasinvestimento.entities.Carteira;
import com.quesssystems.sistemacarteirasinvestimento.entities.Moeda;
import com.quesssystems.sistemacarteirasinvestimento.entities.Usuario;
import com.quesssystems.sistemacarteirasinvestimento.exceptions.CarteiraNaoEncontradaException;

import java.util.List;
import java.util.Optional;

public class CarteiraGateway {

    private final CarteiraDataSource carteiraDataSource;

    public CarteiraGateway(CarteiraDataSource carteiraDataSource) {
        this.carteiraDataSource = carteiraDataSource;
    }

    public Carteira criarCarteira(CarteiraDto criarCarteiraDto) {
        CarteiraDto carteiraDto = carteiraDataSource.criarCarteira(criarCarteiraDto);
        return criarEntidade(carteiraDto);
    }

    public Carteira consultarCarteiraPorId(String id) {
        Optional<CarteiraDto> carteiraDtoOptional = carteiraDataSource.consultarCarteiraPorId(id);

        if (carteiraDtoOptional.isEmpty())
            throw new CarteiraNaoEncontradaException(id);

        CarteiraDto carteiraDto = carteiraDtoOptional.get();
        return criarEntidade(carteiraDto);
    }

    public void removerCarteira(Carteira carteira) {
        carteiraDataSource.removerCarteira(criarDto(carteira));
    }

    public List<Carteira> consultarCarteirasPorUsuarioId(String usuarioId) {
        List<CarteiraDto> carteiraDtoList = carteiraDataSource.consultarCarteirasPorUsuarioId(usuarioId);
        return carteiraDtoList.stream().map(this::criarEntidade).toList();
    }

    private Carteira criarEntidade(CarteiraDto carteiraDto) {
        return new Carteira(carteiraDto.id(),
                new Usuario(carteiraDto.usuarioDto().id(), carteiraDto.usuarioDto().email(), carteiraDto.usuarioDto().senha()),
                carteiraDto.acaoDtoList().stream().map(acaoDto -> new Acao(acaoDto.id(), acaoDto.nome(), acaoDto.origem())).toList(),
                carteiraDto.moedaDtoList().stream().map(moedaDto -> new Moeda(moedaDto.id(), moedaDto.nome(), moedaDto.simbolo())).toList());
    }

    private CarteiraDto criarDto(Carteira carteira) {
        return new CarteiraDto(carteira.getId(),
                new UsuarioDto(carteira.getUsuario().getId(), carteira.getUsuario().getEmail(), carteira.getUsuario().getSenha()),
                carteira.getAcaoList().stream().map(acao -> new AcaoDto(acao.getId(), acao.getNome(), acao.getOrigem())).toList(),
                carteira.getMoedaList().stream().map(moeda -> new MoedaDto(moeda.getId(), moeda.getNome(), moeda.getSimbolo())).toList());
    }
}
