package model.entities;

public class Organizador extends Pessoa {

    private static int sequence = 0;

    // Contrutor
    public Organizador(String nome, String cpfCnpj) {
        super(nome, cpfCnpj);
        setId(sequence++);
    }

    @Override
    public String toString() {
        return "ID: " + getId() + "\tNome: " + getNome() + "\tCPF: " + getCpf();
    }
}
