package br.com.rpg.rpg.model;
public final class Guerreiro extends Aventureiro {
    public Guerreiro(String nome, int capacidadeInventario) {
        super(nome, capacidadeInventario);
    }

    @Override
    public void atacar() {
        System.out.println(nome() + " ataca sem vacilação! corpo-a-corpo");
    }
}