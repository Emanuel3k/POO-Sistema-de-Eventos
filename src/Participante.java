package src;

public class Participante {

    public int id;
    public String nome;
    public String cpf;
    public String matricula;

    public Participante(String nome, String cpf, String matricula){
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getCpf() {
        return cpf;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getMatricula(){
        return matricula;
    }
}

