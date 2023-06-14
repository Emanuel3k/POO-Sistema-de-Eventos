package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        Ui.clearScreen();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.print("Titulo do evento: ");
        String titulo = sc.nextLine();

        System.out.print("Descrição do evento: ");
        String descricao = sc.nextLine();

        System.out.print("Local do evento: ");
        String local = sc.nextLine();

        System.out.print("Inicio do evento (dd/MM/yyyy HH:mm): ");
        LocalDateTime inicio = LocalDateTime.parse(sc.nextLine(), fmt);

        System.out.print("Fim do evento (dd/MM/yyyy HH:mm): ");

        LocalDateTime fim = LocalDateTime.parse(sc.nextLine(), fmt);

        eventos.add(new Evento(titulo, descricao, local, inicio, fim));

        while (true) {
            eventos.get(eventos.size() - 1).addOrganizador();
            Ui.clearScreen();
            System.out.print("Deseja adicionar um novo organizador ao evento (S/n): ");
            String op = sc.nextLine().toUpperCase();
            if (op.charAt(0) == 'N') {
                Ui.clearScreen();
                System.out.println("Evento cadastrado com sucesso!");
                return;
            }
        }

    }

    public void editarEvento() {
        Ui.clearScreen();
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento cadastrado no sistema.");
            return;
        }

        System.out.println("Digite o ID do evento que deseja alterar as informações: \n");
        for (Evento evento : eventos) {
            System.out.println("ID: " + evento.getId() + "\t|Nome: " + evento.getTitulo());
        }

        int id = sc.nextInt();
        for (Evento evento : eventos) {
            if (id == evento.getId()) {
                DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

                System.out.println("Titulo do evento: " + evento.getTitulo());
                System.out.print("Novo titulo: ");
                evento.setTitulo(sc.nextLine());

                System.out.println("Descrição do evento: " + evento.getDescricao());
                System.out.print("Nova descrição: ");
                evento.setDescricao(sc.nextLine());

                System.out.println("Local do evento: " + evento.getLocal());
                System.out.print("Novo local: ");
                evento.setLocal(sc.nextLine());

                System.out.println("Data de inicio do evento: " + evento.getInicio());
                System.out.print("Nova data de inicio: ");
                evento.setInicio(LocalDateTime.parse(sc.nextLine(), fmt));

                System.out.println("Data de término do evento: " + evento.getFim());
                System.out.print("Novo data término: ");
                evento.setFim(LocalDateTime.parse(sc.nextLine(), fmt));

                Ui.clearScreen();
                System.out.println("Alteração realizada com sucesso!");
                return;
            }
        }

        Ui.clearScreen();
        System.out.println("Não foi possivel alterar as informações do evento selecionado.\nTente Novamente!");
    }

    public void rmvEvento() {
        Ui.clearScreen();
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento cadastrado no sistema.");
            return;
        }

        System.out.println("Digite o ID do evento que será removido: \n");
        for (Evento evento : eventos) {
            System.out.println("ID: " + evento.getId() + "\t|Titulo: " + evento.getTitulo());
        }

        int id = sc.nextInt();
        for (Evento evento : eventos) {
            if (id == evento.getId()) {
                eventos.remove(id);

                Ui.clearScreen();
                System.out.println("Evento removido com sucesso!");
                return;
            }
        }

        Ui.clearScreen();
        System.out.println("Não foi possivel remover o evento selecionado.\nTente Novamente!");
    }

    public void listarEvento() {
        Ui.clearScreen();
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento cadastrado no sistema.");
            return;
        }

        for (Evento evento : eventos) {
            System.out.println("Nome: " + evento.getTitulo() + "\t|Descrição: " + evento.getDescricao()
                    + "\t|Duração: " + evento.cargaHoraria());
        }
    }

    public void gerirEvento() {
        Ui.clearScreen();
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento cadastrado no sistema.");
            return;
        }

        System.out.println("Digite o ID do evento que deseja gerenciar: ");
        for (Evento evento : eventos) {
            System.out.println("ID: " + evento.getId() + "\t|Titulo: " + evento.getTitulo());
        }

        int id = sc.nextInt();
        Evento e = null;
        for (Evento evento : eventos) {
            if (id == evento.getId()) {
                e = evento;

                while (true) {
                    subMenuGerenciar();
                    int op = sc.nextInt();
                    switch (op) {
                        case 0:
                            return;

                        case 1: // ADICIONAR PARTICIPANTE
                            e.addParticipante();
                            break;

                        case 2: // EDITAR PARTICIPANTE
                            e.editarParticipante();
                            break;

                        case 3: // LISTAR PARTICIPANTE
                            e.listarParticipante();
                            break;

                        case 4: // REMOVER PARTICIPANTE
                            e.rmvParticipante();
                            break;

                        default:
                            Ui.clearScreen();
                            System.out.println("Operação nao disponivel.\nTente novamente.");
                            break;
                    }
                }
            }
        }

        Ui.clearScreen();
        System.out.println("ID do evento invávilo.\nTente novamente.");
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
        System.out.println("0 - Voltar ao menu principal");
        System.out.println("1 - Adicionar participante ao evento");
        System.out.println("2 - Editar informações do participante");
        System.out.println("3 - Listar participantes");
        System.out.println("4 - Remover participante");
    }

}
