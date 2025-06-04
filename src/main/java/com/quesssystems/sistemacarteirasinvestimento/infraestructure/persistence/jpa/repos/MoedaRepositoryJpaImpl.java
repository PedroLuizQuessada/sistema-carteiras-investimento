package com.quesssystems.sistemacarteirasinvestimento.infraestructure.persistence.jpa.repos;

import com.quesssystems.sistemacarteirasinvestimento.datasources.MoedaDataSource;
import com.quesssystems.sistemacarteirasinvestimento.dtos.MoedaDto;
import com.quesssystems.sistemacarteirasinvestimento.infraestructure.persistence.jpa.mappers.MoedaDtoJpaMapper;
import com.quesssystems.sistemacarteirasinvestimento.infraestructure.persistence.jpa.model.MoedaJpa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MoedaRepositoryJpaImpl implements MoedaDataSource {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private MoedaDtoJpaMapper moedaDtoJpaMapper;

    @Override
    public Optional<MoedaDto> consultarMoedaPorId(String id) {
        Optional<MoedaJpa> optionalMoedaJpa = Optional.ofNullable(entityManager.find(MoedaJpa.class, id));
        return optionalMoedaJpa.map(moedaDtoJpaMapper::toMoedaDto);
    }
}
