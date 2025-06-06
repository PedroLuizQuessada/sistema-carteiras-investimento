package com.quesssystems.sistemacarteirasinvestimento.infraestructure.persistence.jpa.repos;

import com.quesssystems.sistemacarteirasinvestimento.datasources.CarteiraDataSource;
import com.quesssystems.sistemacarteirasinvestimento.dtos.CarteiraDto;
import com.quesssystems.sistemacarteirasinvestimento.infraestructure.persistence.jpa.mappers.CarteiraDtoJpaMapper;
import com.quesssystems.sistemacarteirasinvestimento.infraestructure.persistence.jpa.model.CarteiraJpa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class CarteiraRepositoryJpaImpl implements CarteiraDataSource {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CarteiraDtoJpaMapper carteiraDtoJpaMapper;

    @Override
    @Transactional
    public CarteiraDto criarCarteira(CarteiraDto carteiraDto) {
        CarteiraJpa carteiraJpa = carteiraDtoJpaMapper.toCarteiraJpa(carteiraDto);
        carteiraJpa = entityManager.merge(carteiraJpa);
        return carteiraDtoJpaMapper.toCarteiraDto(carteiraJpa);
    }

    @Override
    public Optional<CarteiraDto> consultarCarteiraPorId(String id) {
        Optional<CarteiraJpa> optionalCarteiraJpa = Optional.ofNullable(entityManager.find(CarteiraJpa.class, id));
        return optionalCarteiraJpa.map(carteiraDtoJpaMapper::toCarteiraDto);

    }

    @Override
    @Transactional
    public void removerCarteira(CarteiraDto carteiraDto) {
        CarteiraJpa carteiraJpa = carteiraDtoJpaMapper.toCarteiraJpa(carteiraDto);
        carteiraJpa = entityManager.merge(carteiraJpa);
        entityManager.remove(carteiraJpa);
    }

    @Override
    public List<CarteiraDto> consultarCarteirasPorUsuarioId(String usuarioId) {
        Query query = entityManager.createQuery("SELECT carteira FROM CarteiraJpa carteira WHERE carteira.usuario.id = :usuarioId");
        query.setParameter("usuarioId", usuarioId);
        List<CarteiraJpa> carteiraJpaList = query.getResultList();
        return carteiraJpaList.stream().map(carteiraJpa -> carteiraDtoJpaMapper.toCarteiraDto(carteiraJpa)).toList();
    }
}
