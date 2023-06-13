package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import app.Ui;
import model.entities.Evento;
import model.entities.Participante;

public class Usuario {
    // ATRIBUTOS
    private String login;
    private List<Evento> eventos = new ArrayList<>();


    Scanner sc = new Scanner(System.in);
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    // CONSTRUTOR
    public Usuario(String login) {
        this.login = login;
    }

    // METODOS
    public void cadEvento() {
        Ui.clearScreen();
        System.out.println("CADASTRO DE EVENTO");
        System.out.println("Titulo:");
        String titulo = sc.nextLine();
        System.out.println("Descrição:");
        String descricao = sc.nextLine();
        System.out.println("Local:");
        String local = sc.nextLine();
        System.out.print("Inicio do evento (dd/MM/yyyy HH:mm): ");
        LocalDateTime inicio = LocalDateTime.parse(sc.nextLine(), fmt);
        System.out.print("Fim do evento (dd/MM/yyyy HH:mm): ");
        LocalDateTime fim = LocalDateTime.parse(sc.nextLine(), fmt);
        Evento evento = new Evento(titulo,descricao,local,inicio,fim);
        //evento.addOrganizador();
        eventos.add(evento);

    }

    public void editEvento() {
        Ui.clearScreen();
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento cadastrado.");
            return;
        }

        System.out.println("Digite o ID do evento que deseja alterar as informações: \n");
        for (Evento evento : eventos) {
            System.out.println("ID: " + evento.getId() + "\t|Nome: " + evento.getTitulo());
        }

        int id = sc.nextInt();
        for (Evento evento : eventos) {
            if (id == evento.getId()) {
                System.out.println("Titulo do evento: " + evento.getTitulo());
                System.out.print("Novo evento: ");
                evento.setTitulo(sc.nextLine());

                System.out.println("Descrição do evento: " + evento.getDescricao());
                System.out.print("Nova descrição: ");
                evento.setDescricao(sc.nextLine());

                System.out.println("Local do evento: " + evento.getLocal());
                System.out.print("Novo local: ");
                evento.setLocal(sc.nextLine());

                System.out.println("Data de inicio do evento: " + evento.getInicio());
                System.out.print("Novo evento: ");
                evento.setInicio(LocalDateTime.parse(sc.nextLine(), fmt));

                System.out.println("Data de término do evento: " + evento.getFim());
                System.out.print("Novo término: ");
                evento.setFim(LocalDateTime.parse(sc.nextLine(), fmt));

                System.out.println("Alteração realizada com sucesso!");
                return;
            }
        }

        System.out.println("Não foi possivel alterar as informações do evento selecionado.\nTente Novamente!");
    }

    public void rmvEvento() {
        Ui.clearScreen();
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento cadastrado.");
            return;
        }

        System.out.println("Digite o ID do evento que será removido: \n");
        for (Evento evento : eventos) {
            System.out.println("Nome: "+evento.getTitulo() + "  |Descrição: "+evento.getDescricao() + "  |Carga horaria: "+evento.cargaHoraria()+"\n");        }

        int id = sc.nextInt();
        for (Evento evento : eventos) {
            if (id == evento.getId()) {
                eventos.remove(id);
                System.out.println("Evento removido com sucesso!");
                return;
            }
        }

        System.out.println("Não foi possivel remover o evento selecionado.\nTente Novamente!");
    }

    public void listarEvento() {
        for(Evento evento : eventos){
            System.out.println("Nome: "+evento.getTitulo() + "  |Descrição: "+evento.getDescricao() + "  |Carga horaria: "+evento.cargaHoraria()+"\n");
        }
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
                    break;

                case 4:
                    editEvento();
                    break;
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
        System.out.println("4 - Editar informação do evento");
    }

}
