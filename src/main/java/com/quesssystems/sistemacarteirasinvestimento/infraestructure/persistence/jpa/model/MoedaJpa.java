package com.quesssystems.sistemacarteirasinvestimento.infraestructure.persistence.jpa.model;

import com.quesssystems.sistemacarteirasinvestimento.infraestructure.exceptions.NomeMoedaJpaInvalidoException;
import com.quesssystems.sistemacarteirasinvestimento.infraestructure.exceptions.SimboloMoedaJpaInvalidoException;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "moedas")
@Getter
@Setter
@NoArgsConstructor
public class MoedaJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 45)
    private String nome;

    @Column(nullable = false, length = 5)
    private String simbolo;

    public MoedaJpa(Long id, String nome, String simbolo) {
        validarNome(nome);
        validarSimbolo(simbolo);

        this.id = id;
        this.nome = nome;
        this.simbolo = simbolo;
    }

    private void validarNome(String nome) {
        int numeroMaximoCaracteres = 45;

        if (Objects.isNull(nome))
            throw new NomeMoedaJpaInvalidoException();

        if (nome.length() > numeroMaximoCaracteres)
            throw new NomeMoedaJpaInvalidoException(numeroMaximoCaracteres);
    }

    private void validarSimbolo(String simbolo) {
        int numeroMaximoCaracteres = 5;

        if (Objects.isNull(simbolo))
            throw new SimboloMoedaJpaInvalidoException();

        if (simbolo.length() > numeroMaximoCaracteres)
            throw new SimboloMoedaJpaInvalidoException(numeroMaximoCaracteres);
    }
}
