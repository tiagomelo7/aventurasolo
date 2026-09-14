public class Main {
    public static void main(String[] args){
        System.out.println("tudo ok, faça sua play!");

        Aventureiro aventureiro = new Guerreiro("melotigas", 3);
        System.out.println("Aventureiro criado: " + aventureiro.nome() + " | Energia: " + aventureiro.energia());
        System.out.println("Capacidade do Inventário: " + aventureiro.inventario().capacidade());
        
        aventureiro.atacar();

        Item espada = new Item("Espada de Aço", TipoItem.ARMA, Raridade.RARO, 150);
        Item pocao = new Item("Poção de Cura", TipoItem.CONSUMIVEL, Raridade.COMUM, 25);
        Item arcoeflecha = new Item("Arco e Flecha", TipoItem.ARMA, Raridade.RARO, 100);

        boolean add1 = aventureiro.inventario().adicionar(espada);
        boolean add2 = aventureiro.inventario().adicionar(pocao);
        System.out.println("Item 1 adicionado? " + add1 + " (" + espada.nome() + ")");
        System.out.println("Item 2 adicionado? " + add2 + " (" + pocao.nome() + ")");
        System.out.println("Qtd de itens no inventário: " + aventureiro.inventario().quantidadeItens());

        Item escudoBonus = new Item("Escudo de Bronze", TipoItem.ARMA, Raridade.INCOMUM, 80);
        Recompensa recompensa = new Recompensa(500, 100, escudoBonus);
        Missao missao = new Missao("Caça aos Goblins", recompensa);

        aventureiro.aceitarMissao(missao);
        System.out.println("\nMissão aceita por " + aventureiro.nome() + ": " + aventureiro.missaoAtiva().titulo());
        System.out.println("Estado inicial da missão: " + aventureiro.missaoAtiva().estado());

        aventureiro.missaoAtiva().iniciar();
        System.out.println("Estado após iniciar(): " + aventureiro.missaoAtiva().estado());

        Recompensa resultado = aventureiro.missaoAtiva().concluir();
        System.out.println("Estado após concluir(): " + aventureiro.missaoAtiva().estado());
        System.out.println("Recompensa obtida: " + resultado.experiencia() + " XP e " + resultado.moedas() + " moedas.");


        System.out.println("\n2.DEMONSTRAÇÃO DE CENÁRIOS INVÁLIDOS");

        System.out.println("\n2.1 Teste com Exceções");

        try {
            System.out.println("Tentando criar Item com valor negativo...");
            new Item("Faquinha de cortar pão", TipoItem.ARMADURA, Raridade.COMUM, -50);
        } catch (IllegalArgumentException e) {
            System.out.println("Exceção capturada com sucesso: " + e.getMessage());
        }

        try {
            System.out.println("Tentando concluir uma nova missão que ainda esta DISPONIVEL...");
            Missao missaoInvalida = new Missao("Resgate na Mina", new Recompensa(100, 20));
            missaoInvalida.concluir();
        } catch (IllegalStateException e) {
            System.out.println("Exceção capturada com sucesso: " + e.getMessage());
        }

        System.out.println("\n.2 Teste de clamping");
        System.out.println("Energia atual: " + aventureiro.energia());
        System.out.println("Aplicando 500 de dano (muito superior à energia restante)...");
        aventureiro.receberDano(500);
        System.out.println("Energia após dano massivo (deve travar em 0): " + aventureiro.energia());

        System.out.println("\n2.3 Teste de retorno boolean (Inventário Cheio)");
        Item anel = new Item("Anel Solitário", TipoItem.ARMA, Raridade.EPICO, 500);
        System.out.println("Tentando adicionar 4º item ao inventário");
        boolean inserido = aventureiro.inventario().adicionar(anel);
        System.out.println("O item foi inserido? " + inserido + " (Operação recusada sem derrubar o programa)");
    }
}