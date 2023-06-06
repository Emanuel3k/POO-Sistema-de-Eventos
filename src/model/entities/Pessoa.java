package src.model.entities;

public class Pessoa {

    //Atributo
    private String nome;

    //Construtor
    public Pessoa(String nome) {
        this.nome = nome;
    }

    //Get Set
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Nome: " + nome;

    }
}
