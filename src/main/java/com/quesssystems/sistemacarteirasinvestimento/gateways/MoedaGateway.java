package com.quesssystems.sistemacarteirasinvestimento.gateways;

import com.quesssystems.sistemacarteirasinvestimento.datasources.MoedaDataSource;
import com.quesssystems.sistemacarteirasinvestimento.dtos.MoedaDto;
import com.quesssystems.sistemacarteirasinvestimento.entities.Moeda;
import com.quesssystems.sistemacarteirasinvestimento.exceptions.MoedaNaoEncontradaException;

import java.util.Optional;

public class MoedaGateway {

    private final MoedaDataSource moedaDataSource;

    public MoedaGateway(MoedaDataSource moedaDataSource) {
        this.moedaDataSource = moedaDataSource;
    }

    public Moeda consultarMoedaPorId(String id) {
        Optional<MoedaDto> moedaDtoOptional = moedaDataSource.consultarMoedaPorId(id);

        if (moedaDtoOptional.isEmpty())
            throw new MoedaNaoEncontradaException(id);

        MoedaDto moedaDto = moedaDtoOptional.get();
        return criarEntidade(moedaDto);
    }

    private Moeda criarEntidade(MoedaDto moedaDto) {
        return new Moeda(moedaDto.id(), moedaDto.nome(), moedaDto.simbolo());
    }
}
