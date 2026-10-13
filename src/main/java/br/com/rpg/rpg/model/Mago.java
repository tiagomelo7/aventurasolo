package br.com.rpg.rpg.model;
public final class Mago extends Aventureiro {
    public Mago(String nome, int capacidadeInventario) {
        super(nome, capacidadeInventario);
    }

    @Override
    public void atacar() {
        System.out.println(nome() + " lança um katon jutsu bola de fogo! - à distância");
    }
}