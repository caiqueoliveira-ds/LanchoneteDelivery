// Pedido.java
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Cliente cliente;
    private List <LinhaPedido> linhas = new ArrayList<>();

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    // Polimorfismo de compilação: sobrecarga (addItem) - um exemplo de polimorfismo em tempo de 
    // compilação
    public void addItem(Item item) {
        addItem(item, 1);
    }

    public void addItem(Item item, int quantidade) {
        if (item == null) throw new IllegalArgumentException("item nulo");
        if (quantidade <= 0) throw new IllegalArgumentException("quantidade deve ser >= 1");
        linhas.add(new LinhaPedido(item, quantidade));
    }

    public double getTotal() {
        double total = 0.0;
        for (LinhaPedido lp : linhas) {
            total += lp.getItem().getPreco() * lp.getQuantidade(); // chama getPrice() 
                                                                   // polimorficamente
        }
        return total;
    }

    public void printRecibo() {
        System.out.println("Pedido para: " + cliente);
        System.out.println("------------------------------");
        for (LinhaPedido lp : linhas) {
            System.out.println(lp.getQuantidade() + " x " + lp.getItem().toString());
        }
        System.out.println("------------------------------");
        System.out.println("Total: R$ " + String.format("%.2f", getTotal()));
    }

    // Classe interna para representar linha do pedido (encapsula a associação item+quantidade)
    private static class LinhaPedido {
        private Item item;
        private int quantidade;

        public LinhaPedido(Item item, int quantidade) {
            this.item = item;
            this.quantidade = quantidade;
        }

        public Item getItem() {
            return item;
        }

        public int getQuantidade() {
            return quantidade;
        }
    }
}
