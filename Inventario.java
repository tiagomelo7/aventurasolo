import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Inventario {
    private final int capacidade;
    private final List<Item> itens = new ArrayList<>();

    public Inventario(int capacidade) {
        if (capacidade <= 0) {
            throw new IllegalArgumentException("A capacidade do inventario deve ser maior que 0");
        }
        this.capacidade = capacidade;
    }

    public boolean adicionar(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Não é possível adicionar um item vazio");
        }
        if (this.itens.size() >= this.capacidade) {
            return false;
        }
        return this.itens.add(item);
    }

    public boolean remover(Item item) {
        if (item == null) {
            return false;
        }
        return this.itens.remove(item);
    }

    public List<Item> itens() {
        return Collections.unmodifiableList(new ArrayList<>(this.itens));
    }

    public int capacidade() {
        return capacidade;
    }

    public int quantidadeItens() {
        return itens.size();
    }
}