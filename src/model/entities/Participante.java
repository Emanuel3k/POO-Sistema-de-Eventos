package model.entities;

import java.time.LocalDate;

public class Participante {

    // ATRIBUTOS
    private int id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String matricula;

    // CONSTRUTOR
    public Participante(int id, String nome, String cpf, LocalDate dataNascimento, String matricula) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.matricula = matricula;
    }

    // GET SET
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\t|Nome: " + nome + "\t|CPF: " + cpf + "\t|data de nascimento: " + dataNascimento
                + "\t|Numero de matricula: " + matricula + "\n";
    }

}
