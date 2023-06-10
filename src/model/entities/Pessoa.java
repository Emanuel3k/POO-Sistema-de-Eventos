package model.entities;

public abstract class Pessoa {

    // Atributo

    private int id;
    private String nome;
    private String cpfCnpj;

    // Construtor
    public Pessoa(String nome, String cpfCnpj) {
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
    }

    // Get Set

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpfCnpj;
    }

    public void setCpf(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
