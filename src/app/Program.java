package app;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import model.entities.Evento;
import model.entities.Inscricao;
import model.entities.Participante;

public class Program {
    public static void main(String[] args) {
        Ui.clearScreen();
        LinkedList<Evento> listaEvento = new LinkedList<>();
        LinkedList<Inscricao> listaInscricao = new LinkedList<>();
        LinkedList<Participante> listaParticipante = new LinkedList<>();
        int key = 0, idEvent = 0, idParticipante = 0;

        Scanner sc = new Scanner(System.in);
        while (true) {
            menu();

            key = sc.nextInt();

            switch (key) {
                case 0: // SAIR
                    Ui.clearScreen();
                    System.exit(0);
                    break;

                case 1: // CADASTRAR EVENTO
                    listaEvento.add(cadastrarEvento(idEvent, sc));
                    idEvent++;
                    break;

                case 2: // INSCREVER-SE NO EVENTO
                    listaParticipante.add(cadastrarParticipante(idParticipante, sc));
                    idParticipante++;
                    listar(listaEvento);
                    System.out.print("Em qual evento você gostaria de se cadastrar: ");
                    int id = sc.nextInt();
                    Inscricao inscricao = new Inscricao(listaEvento.get(id), listaParticipante.getLast());
                    listaInscricao.add(inscricao);
                    System.out.println(
                            "O Usuario foi cadastrado com sucesso! no evento:" + inscricao.getEvento().getTitulo());
                    break;

                case 3:

                default:
                    Ui.clearScreen();
                    System.out.println("Escolha apenas uma das opções validas\n");
                    break;

            }
        }
    }

    public static void menu() {
        System.out.println("0 - Sair");
        System.out.println("1 - Cadastrar Evento");
        System.out.println("2 - Inscrever-se no evento");
    }

    public static Evento cadastrarEvento(int id, Scanner sc) {
        // METODO PARA CADASTRAR EVENTO (FUTURAMENTE ACREDITO SER POSSIVEL REMOVER
        // DESSA CLASSE E JOGAR EM UMA ADEQUEADA)
        sc.nextLine();
        Ui.clearScreen();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        List<String> organizadores = new LinkedList<>();

        System.out.print("Nome do evento: ");
        String titulo = sc.nextLine();

        System.out.print("Descrição do evento: ");
        String descricao = sc.nextLine();

        System.out.print("Local do evento: ");
        String local = sc.nextLine();

        System.out.print("Inicio do evento (dd/MM/yyyy HH:mm): ");
        LocalDateTime inicio = LocalDateTime.parse(sc.nextLine(), fmt);

        System.out.print("Fim do evento (dd/MM/yyyy HH:mm): ");
        LocalDateTime fim = LocalDateTime.parse(sc.nextLine(), fmt);

        System.out.print("Quantidade de organizadores: ");
        int qtd = sc.nextInt();

        sc.nextLine();
        for (int i = 1; i <= qtd; i++) {
            System.out.println("Digite o nome do " + i + "º organizador(a)");
            organizadores.add(sc.nextLine());
        }

        Evento evento = new Evento(id, titulo, descricao, local, inicio, fim, organizadores);

        Ui.clearScreen();
        System.out.println("Evento cadastrado com sucesso!");

        return evento;
    }

    public static Participante cadastrarParticipante(int id, Scanner sc) {
        // METODO PARA CADASTRAR PARTICIPANTE (FUTURAMENTE ACREDITO SER POSSIVEL REMOVER
        // DESSA CLASSE E JOGAR EM UMA CLASSE)
        sc.nextLine();
        Ui.clearScreen();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Nome do participante: ");
        String nome = sc.nextLine();

        System.out.print("CPF do participante: ");
        String cpf = sc.nextLine();

        System.out.print("Data de nascimento (dd/MM/yyyy): ");
        LocalDate dataNasimento = LocalDate.parse(sc.nextLine(), dtf);

        System.out.print("Numero de matricula: ");
        String matricula = sc.nextLine();

        Participante participante = new Participante(id, nome, cpf, dataNasimento, matricula);

        Ui.clearScreen();

        return participante;
    }

    public static void listar(List<?> lista) {
        System.out.println();

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }
}