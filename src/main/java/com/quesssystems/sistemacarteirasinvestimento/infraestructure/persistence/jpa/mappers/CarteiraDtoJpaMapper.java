package com.quesssystems.sistemacarteirasinvestimento.infraestructure.persistence.jpa.mappers;

import com.quesssystems.sistemacarteirasinvestimento.dtos.CarteiraDto;
import com.quesssystems.sistemacarteirasinvestimento.infraestructure.persistence.jpa.model.CarteiraJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CarteiraDtoJpaMapper {

    private final UsuarioDtoJpaMapper usuarioDtoJpaMapper;
    private final AcaoDtoJpaMapper acaoDtoJpaMapper;
    private final MoedaDtoJpaMapper moedaDtoJpaMapper;

    public CarteiraDto toCarteiraDto(CarteiraJpa carteiraJpa) {
        return new CarteiraDto(String.valueOf(carteiraJpa.getId()),
                usuarioDtoJpaMapper.toUsuarioDto(carteiraJpa.getUsuario()),
                carteiraJpa.getAcaoList().stream().map(acaoDtoJpaMapper::toAcaoDto).toList(),
                carteiraJpa.getMoedaList().stream().map(moedaDtoJpaMapper::toMoedaDto).toList());
    }

    public CarteiraJpa toCarteiraJpa(CarteiraDto carteiraDto) {
        return new CarteiraJpa(Long.valueOf(carteiraDto.id()),
                usuarioDtoJpaMapper.toUsuarioJpa(carteiraDto.usuarioDto()),
                carteiraDto.acaoDtoList().stream().map(acaoDtoJpaMapper::toAcaoJpa).toList(),
                carteiraDto.moedaDtoList().stream().map(moedaDtoJpaMapper::toMoedaJpa).toList());
    }
}
