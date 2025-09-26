// ComboItem.java
import java.util.ArrayList;
import java.util.List;

public class ComboItem extends Item {
    private List<Item> items = new ArrayList<>();
    private double desconto; // ex: 10 = 10%

    public ComboItem(String id, String nome, double desconto) {
        super(id, nome);
        setDesconto(desconto);
    }

    public void addItem(Item item) {
        if (item == null) throw new IllegalArgumentException("item nulo");
        items.add(item);
    }

    public List<Item> getItems() {
        return new ArrayList<Item>(items); // cópia para proteger lista interna
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        if (desconto < 0 || desconto > 100)
            throw new IllegalArgumentException("desconto inválido");
        this.desconto = desconto;
    }

    


    // Polimorfismo em ação: calcula preço com base nos preços dos itens (getPrice de cada Item)
    @Override
    public double getPreco() {
        double sum = 0.0;
        for (Item it : items) {
            sum += it.getPreco(); // chama a implementação correta em runtime
        }
        double calcDesconto = sum * (desconto / 100.0);
        return sum - calcDesconto;
    }

    @Override
    public String getDescricao() {
        StringBuilder sb = new StringBuilder(super.getNome() + " (Combo: ");
        for (Item it : items) {
            sb.append(it.getNome()).append(", ");
        }
        if (!items.isEmpty()) sb.setLength(sb.length() - 2);
        sb.append(") - ").append(desconto).append("% off");
        return sb.toString();
    }
}
