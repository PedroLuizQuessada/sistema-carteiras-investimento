package com.quesssystems.sistemacarteirasinvestimento.infraestructure.persistence.jpa.model;

import com.quesssystems.sistemacarteirasinvestimento.infraestructure.exceptions.NomeRoleJpaInvalidoException;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
public class RoleJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 45)
    private String nome;

    public RoleJpa(Long id, String nome) {
        validarNome(nome);

        this.id = id;
        this.nome = nome;
    }

    private void validarNome(String nome) {
        int numeroMaximoCaracteres = 45;

        if (Objects.isNull(nome))
            throw new NomeRoleJpaInvalidoException();

        if (nome.length() > numeroMaximoCaracteres)
            throw new NomeRoleJpaInvalidoException(numeroMaximoCaracteres);
    }
}
