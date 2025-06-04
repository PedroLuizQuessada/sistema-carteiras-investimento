package com.quesssystems.sistemacarteirasinvestimento.infraestructure.persistence.jpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "carteiras")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarteiraJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private UsuarioJpa usuario;

    @ManyToMany
    @JoinTable(
            name = "carteira_acao",
            joinColumns = @JoinColumn(name = "carteira_id"),
            inverseJoinColumns = @JoinColumn(name = "acao_id")
    )
    private List<AcaoJpa> acaoList;

    @ManyToMany
    @JoinTable(
            name = "carteira_moeda",
            joinColumns = @JoinColumn(name = "carteira_id"),
            inverseJoinColumns = @JoinColumn(name = "moeda_id")
    )
    private List<MoedaJpa> moedaList;
}
