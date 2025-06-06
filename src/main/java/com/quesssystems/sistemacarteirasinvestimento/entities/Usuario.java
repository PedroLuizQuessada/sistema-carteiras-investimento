package com.quesssystems.sistemacarteirasinvestimento.entities;

import com.quesssystems.sistemacarteirasinvestimento.exceptions.EmailUsuarioInvalidoException;
import com.quesssystems.sistemacarteirasinvestimento.exceptions.SenhaUsuarioInvalidaException;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.Objects;

public class Usuario {
    private final String id;
    private final String email;
    private final String senha;

    public Usuario(String id, String email, String senha) {
        validarEmail(email);
        validarSenha(senha);

        this.id = id;
        this.email = email;
        this.senha = senha;
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
