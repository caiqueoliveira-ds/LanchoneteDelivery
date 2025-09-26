// FoodItem.java
public class FoodItem extends Item {
    private int calorias;
    private double preco;

    public FoodItem(String id, String nome, double preco, int calorias) {
        super(id, nome);
        setPreco(preco);
        setCalorias(calorias);
    }
    public int getCalorias() {
        return calorias;
    }
    public void setCalorias(int calorias) {
        if (calorias < 0) throw new IllegalArgumentException("calorias inválidas");
        this.calorias = calorias;
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
        return getNome() + " (Comida, " + calorias + " kcal)";
    }
}
