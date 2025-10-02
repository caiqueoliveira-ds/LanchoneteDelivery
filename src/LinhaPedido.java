
public class LinhaPedido {
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
