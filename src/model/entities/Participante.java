package src.model.entities;

import src.model.entities.Pessoa;

import java.time.LocalDate;
public class Participante extends Pessoa{


    // ATRIBUTOS
    private int id;
    private String cpf;
    private LocalDate dataNascimento;
    private String numMatricula;

    // CONSTRUTOR
    public Participante(String cpf, LocalDate dataNascimento, String numMatricula) {
        super(nome);
        this.id++;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.numMatricula = numMatricula;
    }

    // GET SET
    public int getId() {
        return id;
    }
    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getMatricula() {
        return numMatricula;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\t|CPF: " + cpf + "\t|data de nascimento: " + dataNascimento
                + "\t|Numero de matricula: " + numMatricula + "\n";
    }

}
