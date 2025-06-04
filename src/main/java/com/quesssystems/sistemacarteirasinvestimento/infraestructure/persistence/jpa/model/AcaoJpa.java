package com.quesssystems.sistemacarteirasinvestimento.infraestructure.persistence.jpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "acoes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AcaoJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 45)
    private String nome;

    @Column(nullable = false, length = 45)
    private String origem;
}
