package model;

import java.util.ArrayList;
import java.util.List;

import model.entities.Evento;

public class Usuario {
    // ATRIBUTOS
    private String login;
    private List<Evento> eventos = new ArrayList<>();

    // CONSTRUTOR
    public Usuario(String login) {
        this.login = login;
    }

    // METODOS
    public void cadEvento() {

    }

    public void editEvento() {

    }

    public void rmvEvento() {

    }

    public void listarEvento() {

    }

    // GET SET
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

}
