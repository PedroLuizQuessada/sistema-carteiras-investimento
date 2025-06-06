package com.quesssystems.sistemacarteirasinvestimento.infraestructure.persistence.jpa.model;

import com.quesssystems.sistemacarteirasinvestimento.infraestructure.exceptions.UsuarioCarteiraJpaInvalidoException;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "carteiras")
@Getter
@Setter
@NoArgsConstructor
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

    public CarteiraJpa(Long id, UsuarioJpa usuario, List<AcaoJpa> acaoList, List<MoedaJpa> moedaList) {
        validarUsuario(usuario);

        this.id = id;
        this.usuario = usuario;
        this.acaoList = acaoList;
        this.moedaList = moedaList;
    }

    private void validarUsuario(UsuarioJpa usuario) {
        if (Objects.isNull(usuario) || Objects.isNull(usuario.getId()))
            throw new UsuarioCarteiraJpaInvalidoException();
    }
}
