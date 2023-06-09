package src.model.entities;

import java.time.LocalDate;
public class Participante extends Pessoa{


    // ATRIBUTOS
   private LocalDate dataNascimento;

    public Participante(String nome, String cpf, LocalDate dataNascimento) {
        super(nome, cpf);
        this.dataNascimento = dataNascimento;
    }
    // Get e Set
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\t|CPF: " + cpf + "\t|data de nascimento: " + dataNascimento;
    }

}
