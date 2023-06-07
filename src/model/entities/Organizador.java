package src.model.entities;
public class Organizador extends Pessoa {

        //Atributo
        private int id;

        //Contrutor
        public Organizador(String nome) {
            super(nome);
            this.id++;
        }

        // Get Set
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        @Override
        public String toString(){
            return "ID: " + id;
        }
    }
