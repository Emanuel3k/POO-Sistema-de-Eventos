package src.model.entities;
public class Organizador extends Pessoa {




        //Contrutor
        public Organizador(String nome, String cpf) {
            super(nome, cpf);
            this.id++;
        }


        @Override
        public String toString(){
            return "ID: " + id + "\t Nome: "+ nome+ "\t CPF: "+ cpf;
        }
    }
