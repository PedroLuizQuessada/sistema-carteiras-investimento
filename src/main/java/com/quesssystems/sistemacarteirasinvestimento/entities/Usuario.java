package com.quesssystems.sistemacarteirasinvestimento.entities;

import com.quesssystems.sistemacarteirasinvestimento.exceptions.EmailUsuarioInvalidoException;
import com.quesssystems.sistemacarteirasinvestimento.exceptions.SenhaUsuarioInvalidaException;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Objects;

public class Usuario {
    private final String id;
    private final String email;
    private final String senha;
    private final List<Role> roleList;

    public Usuario(String id, String email, String senha, List<Role> roleList, boolean criptografarSenha) {
        validarEmail(email);
        validarSenha(senha);

        this.id = id;
        this.email = email;
        this.roleList = roleList;

        if (criptografarSenha) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            this.senha = encoder.encode(senha);
        }
        else {
            this.senha = senha;
        }
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    private void validarEmail(String email) {
        if (Objects.isNull(email))
            throw new EmailUsuarioInvalidoException();

        if (!EmailValidator.getInstance().isValid(email))
            throw new EmailUsuarioInvalidoException(email);
    }

    private void validarSenha(String senha) {
        int numeroMinimoCaracteres = 3;

        if (Objects.isNull(senha))
            throw new SenhaUsuarioInvalidaException();

        if (senha.length() < numeroMinimoCaracteres) {
            throw new SenhaUsuarioInvalidaException(numeroMinimoCaracteres);
        }
    }
}
