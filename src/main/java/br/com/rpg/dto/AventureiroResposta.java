
package br.com.rpg.dto;

public record AventureiroResposta(
        long id,
        String nome,
        String classe,
        int energia,
        int capacidadeInventario,
        int quantidadeItens
) {
}