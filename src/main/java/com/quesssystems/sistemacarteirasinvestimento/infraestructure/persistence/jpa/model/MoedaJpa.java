package com.quesssystems.sistemacarteirasinvestimento.infraestructure.persistence.jpa.model;

import com.quesssystems.sistemacarteirasinvestimento.infraestructure.exceptions.NomeMoedaJpaInvalidoException;
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

    public MoedaJpa(Long id, String nome) {
        validarNome(nome);

        this.id = id;
        this.nome = nome;
    }

    private void validarNome(String nome) {
        int numeroMaximoCaracteres = 45;

        if (Objects.isNull(nome))
            throw new NomeMoedaJpaInvalidoException();

        if (nome.length() > numeroMaximoCaracteres)
            throw new NomeMoedaJpaInvalidoException(numeroMaximoCaracteres);
    }
}
