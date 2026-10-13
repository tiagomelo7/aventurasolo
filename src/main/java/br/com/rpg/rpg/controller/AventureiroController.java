
package br.com.rpg.rpg.controller;

import br.com.rpg.dto.AventureiroResposta;
import br.com.rpg.dto.CriarAventureiroRequest;
import br.com.rpg.rpg.service.AventureiroService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/aventureiros")
public class AventureiroController {

    private final AventureiroService service;

    public AventureiroController(AventureiroService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AventureiroResposta> criar(
            @RequestBody CriarAventureiroRequest request) {

        AventureiroResposta resposta = service.criar(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(resposta);
    }

    @GetMapping("/{id}")
    public AventureiroResposta buscarPorId(
            @PathVariable long id) {

        return service.buscarPorId(id);
    }

    @PostMapping("/{id}/dano")
    public AventureiroResposta receberDano(
            @PathVariable long id,
            @RequestBody Map<String, Integer> dados) {

        Integer quantidade = dados.get("quantidade");

        if (quantidade == null) {
            throw new IllegalArgumentException(
                    "Informe a quantidade de dano."
            );
        }

        return service.receberDano(id, quantidade);
    }

    @PostMapping("/{id}/recuperacao")
    public AventureiroResposta recuperarEnergia(
            @PathVariable long id,
            @RequestBody Map<String, Integer> dados) {

        Integer quantidade = dados.get("quantidade");

        if (quantidade == null) {
            throw new IllegalArgumentException(
                    "Informe a quantidade de energia a recuperar."
            );
        }

        return service.recuperarEnergia(id, quantidade);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> tratarDadosInvalidos(
            IllegalArgumentException erro) {

        return ResponseEntity.badRequest().body(
                Map.of("erro", erro.getMessage())
        );
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Map<String, String>> tratarNaoEncontrado(
            NoSuchElementException erro) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of("erro", erro.getMessage())
        );
    }
}
