package br.com.rpg.rpg.model;
public final class Item {
    private final String nome;
    private final TipoItem tipo;
    private final Raridade raridade;
    private final int valor;

    public Item(String nome, TipoItem tipo, Raridade raridade, int valor) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do item não pode ser vazio");
        }
        if (tipo == null) {
            throw new IllegalArgumentException("O tipo do item não pode ser vazio");
        }
        if (raridade == null) {
            throw new IllegalArgumentException("A raridade do item não pode ser vazia");
        }
        if (valor < 0) {
            throw new IllegalArgumentException("O valor do item não pode ser negativo");
        }

        this.nome = nome;
        this.tipo = tipo;
        this.raridade = raridade;
        this.valor = valor;
    }

    public String nome() {
        return nome;
    }

    public TipoItem tipo() {
        return tipo;
    }

    public Raridade raridade() {
        return raridade;
    }

    public int valor() {
        return valor;
    }
}