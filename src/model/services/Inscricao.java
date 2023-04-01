package model.services;

import model.entities.Evento;
import model.entities.Participante;

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
    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    @Override
    public String toString() {
        return "Nome do evento: " + evento + "\nParticipantes: " + participante;
    }

}
