package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import app.Ui;
import model.entities.Evento;

public class Usuario {
    // ATRIBUTOS
    private String login;
    private List<Evento> eventos = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

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

    public void gerirEvento() {
        Ui.clearScreen();
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento cadastrado no sistema!");
            return;
        }

        System.out.println("Digite o ID do evento que deseja gerenciar: ");
        for (Evento evento : eventos) {
            System.out.println("ID: " + evento.getId() + "\t|Titulo" + evento.getTitulo());
        }

        int id = sc.nextInt();
        Evento e = null;
        for (Evento evento : eventos) {
            if (id == evento.getId()) {
                e = evento;
            } else {
                System.out.println("ID de evento invalido.\nTente novamente.");
                return;
            }
        }

        while (true) {
            subMenuGerenciar();
            int op = sc.nextInt();
            switch (op) {
                case 1:
                    e.addParticipante();
                    break;

                case 2:
                    e.editParticipante();
                    break;

                case 3:
                    e.rmvParticipante();

                default:
                    break;
            }
        }

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

    private static void subMenuGerenciar() {
        Ui.clearScreen();
        System.out.println("1 - Adicionar participante ao evento");
        System.out.println("2 - Editar informações do participante");
        System.out.println("3 - Remover participante");
    }

}
