package com.quesssystems.sistemacarteirasinvestimento.infraestructure.config;

import com.quesssystems.sistemacarteirasinvestimento.datasources.CarteiraDataSource;
import com.quesssystems.sistemacarteirasinvestimento.infraestructure.persistence.jpa.repos.CarteiraRepositoryJpaImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public CarteiraDataSource carteiraDataSource() {
        return new CarteiraRepositoryJpaImpl();
    }
}
