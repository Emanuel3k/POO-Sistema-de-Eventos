package model.entities;

public class Inscricao {
    // ATRIBUTOS
    private Evento evento;
    private Participante participante;

    // CONSTRUTOR
    public Inscricao(Evento evento, Participante participante) {
        this.evento = evento;
        this.participante = participante;
    }

    // GET SET
    public Participante getParticipante() {
        return participante;
    }

    public Evento getEvento() {
        return evento;
    }

    @Override
    public String toString() {
        return "Evento: " + evento + "\t|Participantes: " + participante;
    }

}