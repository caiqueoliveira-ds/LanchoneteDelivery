//DrinkItem.java
public class DrinkItem extends Item {
    private double volumeMl;
    private double preco;

    public DrinkItem(String id, String nome, double preco, double volumeMl) {
        super(id, nome);
        setPreco(preco);
        setVolumeMl(volumeMl);
    }
    public double getVolumeMl() {
        return volumeMl;
    }
    public void setVolumeMl(double volumeMl) {
        if (volumeMl <= 0) throw new IllegalArgumentException("volume inválido");
        this.volumeMl = volumeMl;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        if (preco < 0) throw new IllegalArgumentException("preço negativo");
        this.preco = preco;
    }

    @Override
    public String getDescricao() {
        return getNome() + " (Bebida, " + (int)volumeMl + " ml)";
    }
}
