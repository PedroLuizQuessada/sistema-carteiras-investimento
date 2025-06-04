package com.quesssystems.sistemacarteirasinvestimento.gateways;

import com.quesssystems.sistemacarteirasinvestimento.datasources.AcaoDataSource;
import com.quesssystems.sistemacarteirasinvestimento.dtos.AcaoDto;
import com.quesssystems.sistemacarteirasinvestimento.entities.Acao;
import com.quesssystems.sistemacarteirasinvestimento.exceptions.AcaoNaoEncontradaException;

import java.util.Optional;

public class AcaoGateway {

    private final AcaoDataSource acaoDataSource;

    public AcaoGateway(AcaoDataSource acaoDataSource) {
        this.acaoDataSource = acaoDataSource;
    }

    public Acao consultarAcaoPorId(String id) {
        Optional<AcaoDto> acaoDtoOptional = acaoDataSource.consultarAcaoPorId(id);

        if (acaoDtoOptional.isEmpty())
            throw new AcaoNaoEncontradaException(id);

        AcaoDto acaoDto = acaoDtoOptional.get();
        return criarEntidade(acaoDto);
    }

    private Acao criarEntidade(AcaoDto acaoDto) {
        return new Acao(acaoDto.id(), acaoDto.nome(), acaoDto.origem());
    }
}
