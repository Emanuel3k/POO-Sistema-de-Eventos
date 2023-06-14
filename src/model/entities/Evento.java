package model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import app.Ui;

public class Evento {
    // ATRIBUTOS
    private static int sequencia = 0;
    private int id;
    private String titulo;
    private String descricao;
    private String local;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private List<Organizador> organizadores = new ArrayList<>();
    private List<Participante> participantes = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    // CONSTRUTORES
    public Evento(String titulo, String descricao, String local, LocalDateTime inicio, LocalDateTime fim) {
        this.id = sequencia++;
        this.titulo = titulo;
        this.descricao = descricao;
        this.local = local;
        this.inicio = inicio;
        this.fim = fim;
    }

    // METODOS
    public String cargaHoraria() {
        Duration ch = Duration.between(inicio, fim);
        if (ch.toHours() < 1) {
            return ch.toMinutes() + "m";
        }
        return ch.toHours() + "h";
    }

    public void addOrganizador() {
        System.out.print("Nome do organizador: ");
        String nome = sc.nextLine();

        System.out.print("CNPJ do organizador: ");
        String cnpj = sc.nextLine();

        organizadores.add(new Organizador(nome, cnpj));
    }

    public void addParticipante() {
        Ui.clearScreen();
        Random rd = new Random();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Nome do participante: ");
        String nome = sc.nextLine();

        System.out.print("CPF do participante: ");
        String cpf = sc.nextLine();

        System.out.print("Data de nascimento (dd/MM/yyyy): ");
        LocalDate dataNascimento = LocalDate.parse(sc.nextLine(), dtf);

        String numMatricula = "";
        for (int i = 0; i < 12; i++) {
            numMatricula += Integer.toString(rd.nextInt(10));
        }

        participantes.add(new Participante(nome, cpf, dataNascimento, numMatricula));
        Ui.clearScreen();
        System.out.println("Participante cadastrado com sucesso!");
    }

    public void editarParticipante() {
        Ui.clearScreen();
        if (participantes.isEmpty()) {
            System.out.println("Nenhum participante cadastrado no evento.");
            return;
        }

        System.out.println("Digite o ID do participante que deseja alterar as informações: \n");
        for (Participante participante : participantes) {
            System.out.println("ID: " + participante.getId() + "\t|Nome: " + participante.getNome());
        }

        int id = sc.nextInt();
        for (Participante participante : participantes) {
            if (id == participante.getId()) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                System.out.println("Nome do participante: " + participante.getNome());
                System.out.print("Novo nome: ");
                participante.setNome(sc.nextLine());

                System.out.println("CPF do participante: " + participante.getCpf());
                System.out.print("Novo CPF: ");
                participante.setCpf(sc.nextLine());

                System.out.println("Data de nascimento: " + participante.getDataNascimento());
                System.out.print("Nova data de nascimento (dd/MM/yyyy): ");
                participante.setDataNascimento(LocalDate.parse(sc.nextLine(), dtf));

                Ui.clearScreen();
                System.out.println("Alteração realizada com sucesso!");
                return;
            }
        }

        Ui.clearScreen();
        System.out.println("Não foi possivel alterar as informações do usuario selecionado.\nTente Novamente!");
    }

    public void rmvParticipante() {
        Ui.clearScreen();
        if (participantes.isEmpty()) {
            System.out.println("Nenhum participante cadastrado no evento.");
            return;
        }

        System.out.println("Digite o ID do participante que será removido: \n");
        for (Participante participante : participantes) {
            System.out.println("ID: " + participante.getId() + "\t|Nome: " + participante.getNome());
        }

        int id = sc.nextInt();
        for (Participante participante : participantes) {
            if (id == participante.getId()) {
                participantes.remove(id);
                Ui.clearScreen();
                System.out.println("Participante removido com sucesso!");
                return;
            }
        }

        Ui.clearScreen();
        System.out.println("Não foi possivel remover o participante selecionado.\nTente Novamente!");
    }

    public void listarParticipante() {
        Ui.clearScreen();
        if (participantes.isEmpty()) {
            System.out.println("Nenhum participante cadastrado no evento.");
            return;
        }

        for (Participante participante : participantes) {
            System.out.println("Nome: " + participante.getNome() + "\t|CPF: " + participante.getCpf()
                    + "\t|Numero de matricula: " + participante.getNumMatricula() + "\t|Data de nascimento: "
                    + participante.getDataNascimento());
        }

    }

    // GET AND SET
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }

    public List<Organizador> getOrganizadores() {
        return organizadores;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + "\t|Titulo: " + titulo + "\tDescricao: " + descricao + "\t|Local: " + getLocal()
                + "\t|Inicio: "
                + getInicio() + "\t|Fim: " + getFim();
    }
}