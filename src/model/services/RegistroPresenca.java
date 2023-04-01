package model.services;

public class RegistroPresenca {
    // ATRIBUTOS
    private Inscricao inscricao;
    
    public RegistroPresenca(Inscricao inscricao) {
        this.inscricao = inscricao;
    }

    public Inscricao getInscricao() {
        return inscricao;
    }

    public void setInscricao(Inscricao inscricao) {
        this.inscricao = inscricao;
    }
}
