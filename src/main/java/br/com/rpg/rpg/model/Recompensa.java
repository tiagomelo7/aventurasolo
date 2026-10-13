package br.com.rpg.rpg.model;
public final class Recompensa {
    private final int experiencia;
    private final int moedas;
    private final Item itemBonus;

    public Recompensa(int experiencia, int moedas, Item itemBonus) {
        if (experiencia < 0) {
            throw new IllegalArgumentException("A quantidade de xp não pode ser negativa.");
        }
        if (moedas < 0) {
            throw new IllegalArgumentException("A quantidade de moedas não pode ser negativa.");
        }
        this.experiencia = experiencia;
        this.moedas = moedas;
        this.itemBonus = itemBonus;
    }

    public Recompensa(int experiencia, int moedas) {
        this(experiencia, moedas, null);
    }

    public int experiencia() {
        return experiencia;
    }

    public int moedas() {
        return moedas;
    }

    public Item itemBonus() {
        return itemBonus;
    }

    public boolean possuiItemBonus() {
        return itemBonus != null;
    }
}