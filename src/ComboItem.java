// ComboItem.java
import java.util.ArrayList;
import java.util.List;

public class ComboItem extends Item {
    private List<Item> items = new ArrayList<>();
    private double desconto; // ex: 10 = 10%
    private boolean descontoProgressivo = false;


    public ComboItem(String id, String nome, List<Item> items, double desconto) {
        super(id, nome);
        this.items = items;
        this.desconto = desconto;
    }

    public ComboItem(String id, String nome, double desconto) {
        super(id, nome);
        setDesconto(desconto);
    }

    public ComboItem(String id, String nome, List<Item> items, double desconto, boolean descontoProgressivo) {
        super(id, nome);
        this.items = items;
        this.desconto = desconto;
        this.descontoProgressivo = descontoProgressivo;
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

    public boolean isDescontoProgressivo() {
        return descontoProgressivo;
    }

    public void setDescontoProgressivo(boolean descontoProgressivo) {
        this.descontoProgressivo = descontoProgressivo;
    }

    // Polimorfismo em ação: calcula preço com base nos preços dos itens e aplica desconto
    @Override
    public double getPreco() {
        double sum = 0.0;
        for (Item it : items) {
            sum += it.getPreco(); // chama a implementação correta em runtime
        }
        
        if (descontoProgressivo) {
            return calcularPrecoComDescontoProgressivo(sum);
        } else {
            double calcDesconto = sum * (desconto / 100.0);
            return sum - calcDesconto;
        }
    }

    private double calcularPrecoComDescontoProgressivo(double precoTotal) {
        if (items.size() <= 1) {
            // Sem desconto progressivo para 1 item
            double calcDesconto = precoTotal * (desconto / 100.0);
            return precoTotal - calcDesconto;
        }
        
        // Desconto progressivo: quanto mais itens, maior o desconto
        // Exemplo: 2 itens = desconto base, 3 itens = +5%, 4 itens = +10%, etc.
        int quantidadeItens = items.size();
        double descontoAdicional = (quantidadeItens - 2) * 5.0; // +5% para cada item além do segundo
        double descontoTotal = Math.min(desconto + descontoAdicional, 50.0); // limite máximo de 50%
        
        double calcDesconto = precoTotal * (descontoTotal / 100.0);
        return precoTotal - calcDesconto;
    }

    @Override
    public String getDescricao() {
        StringBuilder sb = new StringBuilder(super.getNome() + " (Combo: ");
        for (Item it : items) {
            sb.append(it.getNome()).append(", ");
        }
        if (!items.isEmpty()) sb.setLength(sb.length() - 2);
        
        if (descontoProgressivo) {
            sb.append(") - ").append(desconto).append("% off + desconto progressivo");
        } else {
            sb.append(") - ").append(desconto).append("% off");
        }
        return sb.toString();
    }

    // Método para obter o desconto total aplicado
    public double getDescontoTotalAplicado() {
        if (!descontoProgressivo) {
            return desconto;
        }
        
        if (items.size() <= 1) {
            return desconto;
        }
        
        int quantidadeItens = items.size();
        double descontoAdicional = (quantidadeItens - 2) * 5.0;
        return Math.min(desconto + descontoAdicional, 50.0);
    }
}