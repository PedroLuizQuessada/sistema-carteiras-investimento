package com.quesssystems.sistemacarteirasinvestimento.infraestructure.persistence.jpa.repos;

import com.quesssystems.sistemacarteirasinvestimento.datasources.UsuarioDataSource;
import com.quesssystems.sistemacarteirasinvestimento.dtos.UsuarioDto;
import com.quesssystems.sistemacarteirasinvestimento.infraestructure.persistence.jpa.mappers.UsuarioDtoJpaMapper;
import com.quesssystems.sistemacarteirasinvestimento.infraestructure.persistence.jpa.model.UsuarioJpa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UsuarioRepositoryJpaImpl implements UsuarioDataSource {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private UsuarioDtoJpaMapper usuarioDtoJpaMapper;

    @Override
    public Optional<UsuarioDto> consultarUsuarioPorId(String id) {
        Optional<UsuarioJpa> optionalUsuarioJpa = Optional.ofNullable(entityManager.find(UsuarioJpa.class, id));
        return optionalUsuarioJpa.map(usuarioDtoJpaMapper::toUsuarioDto);

    }
}
