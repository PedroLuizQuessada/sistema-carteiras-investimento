package com.quesssystems.sistemacarteirasinvestimento.infraestructure.persistence.jpa.repos;

import com.quesssystems.sistemacarteirasinvestimento.datasources.AcaoDataSource;
import com.quesssystems.sistemacarteirasinvestimento.dtos.AcaoDto;
import com.quesssystems.sistemacarteirasinvestimento.infraestructure.persistence.jpa.mappers.AcaoDtoJpaMapper;
import com.quesssystems.sistemacarteirasinvestimento.infraestructure.persistence.jpa.model.AcaoJpa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AcaoRepositoryJpaImpl implements AcaoDataSource {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private AcaoDtoJpaMapper acaoDtoJpaMapper;

    @Override
    public Optional<AcaoDto> consultarAcaoPorId(String id) {
        Optional<AcaoJpa> optionalAcaoJpa = Optional.ofNullable(entityManager.find(AcaoJpa.class, id));
        return optionalAcaoJpa.map(acaoDtoJpaMapper::toAcaoDto);
    }
}
