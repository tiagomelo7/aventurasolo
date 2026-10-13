
package br.com.rpg.dto;

public record CriarAventureiroRequest(
        String nome,
        int capacidadeInventario,
        String classe
) {
}