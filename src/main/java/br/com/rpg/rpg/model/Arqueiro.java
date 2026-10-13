package br.com.rpg.rpg.model;
public final class Arqueiro extends Aventureiro {
    public Arqueiro(String nome, int capacidadeInventario) {
        super(nome, capacidadeInventario);
    }

    @Override
    public void atacar() {
        System.out.println(nome() + " dispara uma flecha 'acerto mizeravi'! à distância");
    }
}