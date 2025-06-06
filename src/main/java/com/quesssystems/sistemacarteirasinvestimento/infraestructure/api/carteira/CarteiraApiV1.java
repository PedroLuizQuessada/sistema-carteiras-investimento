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
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1/carteira")
public class CarteiraApiV1 {

    private final CarteiraController carteiraController;

    public CarteiraApiV1(CarteiraDataSource carteiraDataSource,
                         UsuarioDataSource usuarioDataSource,
                         AcaoDataSource acaoDataSource,
                         MoedaDataSource moedaDataSource) {
        this.carteiraController = new CarteiraController(carteiraDataSource, usuarioDataSource, acaoDataSource, moedaDataSource);
    }

    @GetMapping("/acoes/{carteira-id}")
    ResponseEntity<List<AcaoDtoResponse>> consultarAcoesPorCarteiraId(@PathVariable("carteira-id") @NotNull String carteiraId) {
        log.info("Buscando ações da carteira de ID: {}", carteiraId);
        return ResponseEntity
                .ok(carteiraController.consultarAcoesPorCarteiraId(carteiraId));
    }

    @GetMapping("/carteiras/{usuario-id}")
    ResponseEntity<List<CarteiraDtoResponse>> consultarCarteirasPorUsuarioId(@PathVariable("usuario-id") @NotNull String usuarioId) {
        log.info("Buscando carteiras do usuário de ID: {}", usuarioId);
        return ResponseEntity
                .ok(carteiraController.consultarCarteirasPorUsuarioId(usuarioId));
    }

    @GetMapping("/{id}")
    ResponseEntity<CarteiraDtoResponse> consultarCarteira(@PathVariable("id") @NotNull String id) {
        log.info("Buscando carteira de ID: {}", id);
        return ResponseEntity
                .ok(carteiraController.consultarCarteira(id));
    }

    @GetMapping("/moedas/{carteira-id}")
    ResponseEntity<List<MoedaDtoResponse>> consultarMoedasPorCarteiraId(@PathVariable("carteira-id") @NotNull String carteiraId) {
        log.info("Buscando moedas da carteira de ID: {}", carteiraId);
        return ResponseEntity
                .ok(carteiraController.consultarMoedasPorCarteiraId(carteiraId));
    }

    @PostMapping
    ResponseEntity<CarteiraDtoResponse> criarCarteira(@RequestBody @Valid CriarCarteiraDto criarCarteiraDto) {
        log.info("Criando carteira para usuário de ID: {}", criarCarteiraDto.usuarioId());
        return ResponseEntity
                .ok(carteiraController.criarCarteira(criarCarteiraDto));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> removerCarteira(@PathVariable("id") @NotNull String id) {
        log.info("Removendo carteira de ID: {}", id);
        carteiraController.removerCarteira(id);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
