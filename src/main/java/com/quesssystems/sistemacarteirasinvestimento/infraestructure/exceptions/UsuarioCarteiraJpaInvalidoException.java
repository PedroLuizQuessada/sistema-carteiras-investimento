package com.quesssystems.sistemacarteirasinvestimento.infraestructure.exceptions;

public class UsuarioCarteiraJpaInvalidoException extends RuntimeException {
    public UsuarioCarteiraJpaInvalidoException() {
        super("A carteira deve estar atribuída a um usuário para ser armazenada no banco de dados");
    }
}
