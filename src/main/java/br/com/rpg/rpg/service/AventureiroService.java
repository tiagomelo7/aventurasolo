
package br.com.rpg.rpg.service;

import br.com.rpg.dto.AventureiroResposta;
import br.com.rpg.dto.CriarAventureiroRequest;
import br.com.rpg.rpg.model.Aventureiro;
import br.com.rpg.rpg.model.Arqueiro;
import br.com.rpg.rpg.model.Guerreiro;
import br.com.rpg.rpg.model.Mago;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class AventureiroService {

    private final Map<Long, Aventureiro> aventureiros =
            new ConcurrentHashMap<>();

    private final Map<Long, String> classes =
            new ConcurrentHashMap<>();

    private final AtomicLong proximoId = new AtomicLong(1);

    public AventureiroResposta criar(CriarAventureiroRequest request) {

        if (request == null) {
            throw new IllegalArgumentException(
                    "Os dados do aventureiro são obrigatórios."
            );
        }

        if (request.classe() == null) {
            throw new IllegalArgumentException(
                    "A classe do aventureiro é obrigatória."
            );
        }

        String classe = request.classe().trim().toUpperCase();

        Aventureiro aventureiro = switch (classe) {
            case "GUERREIRO" ->
                    new Guerreiro(
                            request.nome(),
                            request.capacidadeInventario()
                    );
            case "ARQUEIRO" ->
                    new Arqueiro(
                            request.nome(),
                            request.capacidadeInventario()
                    );
            case "MAGO" ->
                    new Mago(
                            request.nome(),
                            request.capacidadeInventario()
                    );
            default -> throw new IllegalArgumentException(
                    "Classe inválida. Use GUERREIRO, ARQUEIRO ou MAGO."
            );
        };

        long id = proximoId.getAndIncrement();

        aventureiros.put(id, aventureiro);
        classes.put(id, classe);

        return converterParaResposta(id, aventureiro);
    }

    public AventureiroResposta buscarPorId(long id) {
        Aventureiro aventureiro = obterAventureiro(id);
        return converterParaResposta(id, aventureiro);
    }

    public AventureiroResposta receberDano(long id, int quantidade) {
        Aventureiro aventureiro = obterAventureiro(id);

        aventureiro.receberDano(quantidade);

        return converterParaResposta(id, aventureiro);
    }

    public AventureiroResposta recuperarEnergia(
            long id, int quantidade) {

        Aventureiro aventureiro = obterAventureiro(id);

        aventureiro.recuperar(quantidade);

        return converterParaResposta(id, aventureiro);
    }

    private Aventureiro obterAventureiro(long id) {
        Aventureiro aventureiro = aventureiros.get(id);

        if (aventureiro == null) {
            throw new java.util.NoSuchElementException(
                    "Aventureiro não encontrado: " + id
            );
        }

        return aventureiro;
    }

    private AventureiroResposta converterParaResposta(
            long id, Aventureiro aventureiro) {

        return new AventureiroResposta(
                id,
                aventureiro.nome(),
                classes.get(id),
                aventureiro.energia(),
                aventureiro.inventario().capacidade(),
                aventureiro.inventario().quantidadeItens()
        );
    }
}
