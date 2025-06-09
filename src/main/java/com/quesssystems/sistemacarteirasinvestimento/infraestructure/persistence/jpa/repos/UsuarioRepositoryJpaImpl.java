package com.quesssystems.sistemacarteirasinvestimento.infraestructure.persistence.jpa.repos;

import com.quesssystems.sistemacarteirasinvestimento.datasources.UsuarioDataSource;
import com.quesssystems.sistemacarteirasinvestimento.dtos.UsuarioDto;
import com.quesssystems.sistemacarteirasinvestimento.infraestructure.persistence.jpa.mappers.UsuarioDtoJpaMapper;
import com.quesssystems.sistemacarteirasinvestimento.infraestructure.persistence.jpa.model.UsuarioJpa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
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
        Query query = entityManager.createQuery("SELECT usuario FROM UsuarioJpa usuario LEFT JOIN FETCH usuario.roleList WHERE usuario.id = :usuarioId");
        query.setParameter("usuarioId", id);
        UsuarioJpa usuarioJpa = (UsuarioJpa) query.getSingleResult();
        return Optional.ofNullable(usuarioDtoJpaMapper.toUsuarioDto(usuarioJpa));
    }

    @Override
    public Optional<UsuarioDto> consultarUsuarioPorEmail(String email) {
        Query query = entityManager.createQuery("SELECT usuario FROM UsuarioJpa usuario LEFT JOIN FETCH usuario.roleList WHERE usuario.email = :usuarioEmail");
        query.setParameter("usuarioEmail", email);
        UsuarioJpa usuarioJpa = (UsuarioJpa) query.getSingleResult();
        return Optional.ofNullable(usuarioDtoJpaMapper.toUsuarioDto(usuarioJpa));
    }
}
