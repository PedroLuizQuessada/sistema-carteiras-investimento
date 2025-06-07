package com.quesssystems.sistemacarteirasinvestimento.infraestructure.api.carteira;

import com.quesssystems.sistemacarteirasinvestimento.controllers.CarteiraController;
import com.quesssystems.sistemacarteirasinvestimento.datasources.AcaoDataSource;
import com.quesssystems.sistemacarteirasinvestimento.datasources.CarteiraDataSource;
import com.quesssystems.sistemacarteirasinvestimento.datasources.MoedaDataSource;
import com.quesssystems.sistemacarteirasinvestimento.datasources.UsuarioDataSource;
import com.quesssystems.sistemacarteirasinvestimento.dtos.requests.CriarCarteiraDto;
import com.quesssystems.sistemacarteirasinvestimento.dtos.responses.AcaoDtoResponse;
import com.quesssystems.sistemacarteirasinvestimento.dtos.responses.CarteiraDtoResponse;
import com.quesssystems.sistemacarteirasinvestimento.dtos.responses.MoedaDtoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1/carteira")
@Tag(name = "Carteira API V1", description = "Versão 1 da API de carteiras")
public class CarteiraApiV1 {

    private final CarteiraController carteiraController;

    public CarteiraApiV1(CarteiraDataSource carteiraDataSource,
                         UsuarioDataSource usuarioDataSource,
                         AcaoDataSource acaoDataSource,
                         MoedaDataSource moedaDataSource) {
        this.carteiraController = new CarteiraController(carteiraDataSource, usuarioDataSource, acaoDataSource, moedaDataSource);
    }

    @Operation(summary = "Consulta ações por carteira ID",
            security = @SecurityRequirement(name = "basicAuth"))
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "Ações consultadas com sucesso",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = AcaoDtoResponse.class)))),
            @ApiResponse(responseCode = "401",
                    description = "Credenciais de acesso inválidas",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class))),
            @ApiResponse(responseCode = "404",
                    description = "Carteira não encontrada",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class)))
    })
    @GetMapping("/acoes/{carteira-id}")
    ResponseEntity<List<AcaoDtoResponse>> consultarAcoesPorCarteiraId(@PathVariable("carteira-id") @NotNull String carteiraId) {
        log.info("Buscando ações da carteira de ID: {}", carteiraId);
        return ResponseEntity
                .ok(carteiraController.consultarAcoesPorCarteiraId(carteiraId));
    }

    @Operation(summary = "Consulta carteiras por usuário ID",
            security = @SecurityRequirement(name = "basicAuth"))
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "Carteiras consultadas com sucesso",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = CarteiraDtoResponse.class)))),
            @ApiResponse(responseCode = "401",
                    description = "Credenciais de acesso inválidas",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class)))
    })
    @GetMapping("/carteiras/{usuario-id}")
    ResponseEntity<List<CarteiraDtoResponse>> consultarCarteirasPorUsuarioId(@PathVariable("usuario-id") @NotNull String usuarioId) {
        log.info("Buscando carteiras do usuário de ID: {}", usuarioId);
        return ResponseEntity
                .ok(carteiraController.consultarCarteirasPorUsuarioId(usuarioId));
    }

    @Operation(summary = "Consulta carteira por ID",
            security = @SecurityRequirement(name = "basicAuth"))
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "Carteira consultada com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CarteiraDtoResponse.class))),
            @ApiResponse(responseCode = "401",
                    description = "Credenciais de acesso inválidas",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class))),
            @ApiResponse(responseCode = "404",
                    description = "Carteira não encontrada",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class)))
    })
    @GetMapping("/{id}")
    ResponseEntity<CarteiraDtoResponse> consultarCarteira(@PathVariable("id") @NotNull String id) {
        log.info("Buscando carteira de ID: {}", id);
        return ResponseEntity
                .ok(carteiraController.consultarCarteira(id));
    }

    @Operation(summary = "Consulta moedas por carteira ID",
            security = @SecurityRequirement(name = "basicAuth"))
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "Moedas consultadas com sucesso",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = MoedaDtoResponse.class)))),
            @ApiResponse(responseCode = "401",
                    description = "Credenciais de acesso inválidas",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class))),
            @ApiResponse(responseCode = "404",
                    description = "Carteira não encontrada",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class)))
    })
    @GetMapping("/moedas/{carteira-id}")
    ResponseEntity<List<MoedaDtoResponse>> consultarMoedasPorCarteiraId(@PathVariable("carteira-id") @NotNull String carteiraId) {
        log.info("Buscando moedas da carteira de ID: {}", carteiraId);
        return ResponseEntity
                .ok(carteiraController.consultarMoedasPorCarteiraId(carteiraId));
    }

    @Operation(summary = "Cria carteira",
            security = @SecurityRequirement(name = "basicAuth"))
    @ApiResponses({
            @ApiResponse(responseCode = "201",
                    description = "Carteira criada com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CarteiraDtoResponse.class))),
            @ApiResponse(responseCode = "401",
                    description = "Credenciais de acesso inválidas",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class))),
            @ApiResponse(responseCode = "400",
                    description = "Campos inválidos",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class)))
    })
    @PostMapping
    ResponseEntity<CarteiraDtoResponse> criarCarteira(@RequestBody @Valid CriarCarteiraDto criarCarteiraDto) {
        log.info("Criando carteira para usuário de ID: {}", criarCarteiraDto.usuarioId());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(carteiraController.criarCarteira(criarCarteiraDto));
    }

    @Operation(summary = "Remover carteira",
            security = @SecurityRequirement(name = "basicAuth"))
    @ApiResponses({
            @ApiResponse(responseCode = "204",
                    description = "Carteira removida com sucesso"),
            @ApiResponse(responseCode = "401",
                    description = "Credenciais de acesso inválidas",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class))),
            @ApiResponse(responseCode = "404",
                    description = "Carteira não encontrada",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class)))
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> removerCarteira(@PathVariable("id") @NotNull String id) {
        log.info("Removendo carteira de ID: {}", id);
        carteiraController.removerCarteira(id);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
