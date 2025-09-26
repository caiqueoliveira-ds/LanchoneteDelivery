// Cliente.java
public class Cliente {
    private String nome;
    private String email;
    private String fone;

    public Cliente(String nome, String email, String fone) {
        setNome(nome);
        setEmail(email);
        setFone(fone);
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) throw new IllegalArgumentException("nome inválido");
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    // Encapsulamento com validação: garante que email tenha formato mínimo
    public void setEmail(String email) {
        if (email == null || !email.contains("@")) throw new IllegalArgumentException("email inválido");
        this.email = email;
    }
    public String getFone() {
        return fone;
    }
    public void setFone(String fone) {
        if (fone == null) fone = "";
        this.fone = fone;
    }
    @Override
    public String toString() {
        return nome + " <" + email + ">";
    }
}
