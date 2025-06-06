package com.quesssystems.sistemacarteirasinvestimento.infraestructure.persistence.jpa.model;

import com.quesssystems.sistemacarteirasinvestimento.infraestructure.exceptions.NomeAcaoJpaInvalidoException;
import com.quesssystems.sistemacarteirasinvestimento.infraestructure.exceptions.OrigemAcaoJpaInvalidaException;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "acoes")
@Getter
@Setter
@NoArgsConstructor
public class AcaoJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 45)
    private String nome;

    @Column(nullable = false, length = 45)
    private String origem;

    public AcaoJpa(Long id, String nome, String origem) {
        validarNome(nome);
        validarOrigem(origem);

        this.id = id;
        this.nome = nome;
        this.origem = origem;
    }

    private void validarNome(String nome) {
        int numeroMaximoCaracteres = 45;

        if (Objects.isNull(nome))
            throw new NomeAcaoJpaInvalidoException();

        if (nome.length() > numeroMaximoCaracteres)
            throw new NomeAcaoJpaInvalidoException(numeroMaximoCaracteres);
    }

    private void validarOrigem(String origem) {
        int numeroMaximoCaracteres = 45;

        if (Objects.isNull(origem))
            throw new OrigemAcaoJpaInvalidaException();

        if (origem.length() > numeroMaximoCaracteres)
            throw new OrigemAcaoJpaInvalidaException(numeroMaximoCaracteres);
    }
}
