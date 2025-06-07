package com.quesssystems.sistemacarteirasinvestimento.infraestructure.persistence.jpa.mappers;

import com.quesssystems.sistemacarteirasinvestimento.dtos.MoedaDto;
import com.quesssystems.sistemacarteirasinvestimento.infraestructure.persistence.jpa.model.MoedaJpa;
import org.springframework.stereotype.Component;

@Component
public class MoedaDtoJpaMapper {

    public MoedaDto toMoedaDto(MoedaJpa moedaJpa) {
        return new MoedaDto(String.valueOf(moedaJpa.getId()), moedaJpa.getNome(), moedaJpa.getSimbolo());
    }

    public MoedaJpa toMoedaJpa(MoedaDto moedaDto) {
        return new MoedaJpa(Long.valueOf(moedaDto.id()), moedaDto.nome(), moedaDto.simbolo());
    }
}
