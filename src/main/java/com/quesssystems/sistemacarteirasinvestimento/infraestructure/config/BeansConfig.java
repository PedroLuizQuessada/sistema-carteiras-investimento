package com.quesssystems.sistemacarteirasinvestimento.infraestructure.config;

import com.quesssystems.sistemacarteirasinvestimento.datasources.AcaoDataSource;
import com.quesssystems.sistemacarteirasinvestimento.datasources.CarteiraDataSource;
import com.quesssystems.sistemacarteirasinvestimento.datasources.MoedaDataSource;
import com.quesssystems.sistemacarteirasinvestimento.datasources.UsuarioDataSource;
import com.quesssystems.sistemacarteirasinvestimento.infraestructure.persistence.jpa.repos.AcaoRepositoryJpaImpl;
import com.quesssystems.sistemacarteirasinvestimento.infraestructure.persistence.jpa.repos.CarteiraRepositoryJpaImpl;
import com.quesssystems.sistemacarteirasinvestimento.infraestructure.persistence.jpa.repos.MoedaRepositoryJpaImpl;
import com.quesssystems.sistemacarteirasinvestimento.infraestructure.persistence.jpa.repos.UsuarioRepositoryJpaImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public CarteiraDataSource carteiraDataSource() {
        return new CarteiraRepositoryJpaImpl();
    }

    @Bean
    public UsuarioDataSource usuarioDataSource() {
        return new UsuarioRepositoryJpaImpl();
    }

    @Bean
    public AcaoDataSource acaoDataSource() {
        return new AcaoRepositoryJpaImpl();
    }

    @Bean
    public MoedaDataSource moedaDataSource() {
        return new MoedaRepositoryJpaImpl();
    }
}
