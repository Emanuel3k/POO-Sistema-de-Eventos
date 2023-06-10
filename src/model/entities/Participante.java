package model.entities;

import java.time.LocalDate;

public class Participante extends Pessoa {

    // ATRIBUTOS
    private static int sequence = 0;
    private LocalDate dataNascimento;
    private String numMatricula;

    public Participante(String nome, String cpfCnpj, LocalDate dataNascimento, String numMatricula) {
        super(nome, cpfCnpj);
        this.dataNascimento = dataNascimento;
        this.numMatricula = numMatricula;
        setId(sequence++);
    }

    // Get e Set
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(String numMatricula) {
        this.numMatricula = numMatricula;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + "\t|CPF: " + getCpf() + "\t|data de nascimento: " + getDataNascimento();
    }

}
