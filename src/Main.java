public class Main {
    public static void main(String[] args) {
        // Criando itens (FoodItem e DrinkItem)
        FoodItem burger = new FoodItem("F1", "X-Burguer", 12.50, 650);
        DrinkItem cola = new DrinkItem("D1", "Coca-Cola", 5.00, 350);

        // Criando um combo
        ComboItem combo = new ComboItem("C1", "Combo Burguer+Refrigerante", 10.0); // 10% off
        combo.addItem(burger);
        combo.addItem(cola);

        // Cliente (encapsulamento com validação)
        Cliente c = new Cliente("Ana", "ana@example.com", "1199999-0000");

        // Pedido (polimorfismo: aceita qualquer Item)
        Pedido pedido = new Pedido(c);
        pedido.addItem(burger);           // sobrecarga: addItem(item)
        pedido.addItem(cola, 2);          // sobrecarga: addItem(item, quantidade)
        pedido.addItem(combo);            // adiciona o combo (ComboItem é um Item)

        // Imprime recibo
        pedido.printRecibo();

        // Saída esperada mostrada abaixo.
    }
}
