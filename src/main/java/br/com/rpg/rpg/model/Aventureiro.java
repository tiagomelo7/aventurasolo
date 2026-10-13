package br.com.rpg.rpg.model;
public abstract class Aventureiro {
    public static final int ENERGIA_MAXIMA = 100;
    private final String nome;
    private int energia;
    private final Inventario inventario;
    private Missao missaoAtiva;

    protected Aventureiro(String nome, int capacidadeInventario) {
        if (nome == null || nome.trim().isBlank()) {
            throw new IllegalArgumentException("O nome do aventureiro não pode ser vazio");
        }
        if (capacidadeInventario <= 0) {
            throw new IllegalArgumentException("A capacidade do inventário deve ser maior que zero");
        }
        this.nome = nome;
        this.energia = ENERGIA_MAXIMA;
        this.inventario = new Inventario(capacidadeInventario);
    }

    public void receberDano(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("A quantidade de dano não pode ser negativa");
        }
        this.energia = Math.max(0, this.energia - quantidade);
    }

    public void recuperar(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade a recuperar deve ser positiva");
        }
        this.energia = Math.min(ENERGIA_MAXIMA, this.energia + quantidade);
    }

    public void aceitarMissao(Missao missao) {
        if (missao == null) {
            throw new IllegalArgumentException("A missao a ser aceita não pode ser vazia");
        }
        this.missaoAtiva = missao;
    }

    // Comportamento que varia por arquétipo
    public abstract void atacar();

    public String nome() {
        return nome;
    }

    public int energia() {
        return energia;
    }

    public Inventario inventario() {
        return inventario;
    }

    public Missao missaoAtiva() {
        return missaoAtiva;
    }
}