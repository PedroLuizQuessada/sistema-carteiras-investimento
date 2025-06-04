package com.quesssystems.sistemacarteirasinvestimento.infraestructure.persistence.jpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "moedas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MoedaJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 45)
    private String nome;
}
