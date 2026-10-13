package br.com.rpg.rpg.model;
public final class Missao {
    private final String titulo;
    private final Recompensa recompensa;
    private EstadoMissao estado;

    public Missao(String titulo, Recompensa recompensa) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("O titulo da missao nao pode ser vazio");
        }
        if (recompensa == null) {
            throw new IllegalArgumentException("A recompensa nao pode ser vazia");
        }
        this.titulo = titulo;
        this.recompensa = recompensa;
        this.estado = EstadoMissao.DISPONIVEL;
    }

    public void iniciar() {
        if (this.estado != EstadoMissao.DISPONIVEL) {
            throw new IllegalStateException("voce só pode iniciar uma missao disponivel");
        }
        this.estado = EstadoMissao.EM_ANDAMENTO;
    }

    public Recompensa concluir() {
        if (this.estado != EstadoMissao.EM_ANDAMENTO) {
            throw new IllegalStateException("A missao so pode ser concluida se estiver em andamento");
        }
        this.estado = EstadoMissao.CONCLUIDA;
        return this.recompensa;
    }

    public String titulo() {
        return titulo;
    }

    public EstadoMissao estado() {
        return estado;
    }

    public Recompensa recompensa() {
        return recompensa;
    }
}