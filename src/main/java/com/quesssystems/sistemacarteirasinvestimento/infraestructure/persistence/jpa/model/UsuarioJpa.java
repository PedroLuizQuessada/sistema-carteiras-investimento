package com.quesssystems.sistemacarteirasinvestimento.infraestructure.persistence.jpa.model;

import com.quesssystems.sistemacarteirasinvestimento.infraestructure.exceptions.EmailUsuarioJpaInvalidoException;
import com.quesssystems.sistemacarteirasinvestimento.infraestructure.exceptions.SenhaUsuarioJpaInvalidaException;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
public class UsuarioJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(nullable = false, length = 255)
    private String senha;

    @ManyToMany
    @JoinTable(
            name = "usuario_role",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<RoleJpa> roleList;

    public UsuarioJpa(Long id, String email, String senha, List<RoleJpa> roleList) {
        validarEmail(email);
        validarSenha(senha);

        this.id = id;
        this.email = email;
        this.senha = senha;
        this.roleList = roleList;
    }

    private void validarEmail(String email) {
        int numeroMaximoCaracteres = 45;

        if (Objects.isNull(email))
            throw new EmailUsuarioJpaInvalidoException();

        if (email.length() > numeroMaximoCaracteres)
            throw new EmailUsuarioJpaInvalidoException(numeroMaximoCaracteres);
    }

    private void validarSenha(String senha) {
        int numeroMaximoCaracteres = 255;

        if (Objects.isNull(senha))
            throw new SenhaUsuarioJpaInvalidaException();

        if (senha.length() > numeroMaximoCaracteres)
            throw new SenhaUsuarioJpaInvalidaException(numeroMaximoCaracteres);
    }
}
