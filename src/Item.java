// Item.java
public abstract class Item {
    private String id;
    private String nome;

    public Item(String id, String nome) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("id inválido");
        }
        this.id = id;
        this.nome = nome;
    }
    // Encapsulamento: campos privados com getters
    public String getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    // Abstração: cada Item sabe como calcular seu preço,
    // mas a implementação é deixada para as subclasses.
    public abstract double getPreco();

    // Método não abstrato — pode ser substituído (override).
    public String getDescricao() {
        return nome;
    }
    @Override
    public String toString() {
        return getDescricao() + " - R$ " + String.format("%.2f", getPreco());
    }
}

