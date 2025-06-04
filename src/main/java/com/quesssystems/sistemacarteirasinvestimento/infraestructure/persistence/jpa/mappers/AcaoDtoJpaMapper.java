package com.quesssystems.sistemacarteirasinvestimento.infraestructure.persistence.jpa.mappers;

import com.quesssystems.sistemacarteirasinvestimento.dtos.AcaoDto;
import com.quesssystems.sistemacarteirasinvestimento.infraestructure.persistence.jpa.model.AcaoJpa;
import org.springframework.stereotype.Component;

@Component
public class AcaoDtoJpaMapper {

    public AcaoDto toAcaoDto(AcaoJpa acaoJpa) {
        return new AcaoDto(String.valueOf(acaoJpa.getId()), acaoJpa.getNome(), acaoJpa.getOrigem());
    }

    public AcaoJpa toAcaoJpa(AcaoDto acaoDto) {
        return new AcaoJpa(Long.valueOf(acaoDto.id()), acaoDto.nome(), acaoDto.origem());
    }
}
