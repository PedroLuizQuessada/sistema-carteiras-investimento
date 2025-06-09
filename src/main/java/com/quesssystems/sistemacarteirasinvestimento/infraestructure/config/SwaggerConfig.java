package com.quesssystems.sistemacarteirasinvestimento.infraestructure.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "basicAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "basic",
        bearerFormat = "Basic"
)
@OpenAPIDefinition(
        info = @Info(title = "API sistema de carteiras de investimento", version = "v1.0.0",
                description = "API para gerenciamento de carteiras de investimento")
)
public class SwaggerConfig {
}
