package com.quesssystems.sistemacarteirasinvestimento.enums;

import lombok.Getter;

public enum AuthorityEnum {
    ADMIN("ADMIN");

    @Getter
    private final String nome;

    AuthorityEnum(String nome) {
        this.nome = nome;
    }
}
