package app;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.entities.Evento;
import model.entities.Participante;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Program aux = new Program();
        List<Evento> listaEvento = new ArrayList<>();

        int a = 1;
        while (a==1){

            println("1 - Cadastrar Evento");
            println("2 - Cadastrar Participantes");
            println("9 - Sair");
            int b = sc.nextInt();
            switch (b){

                case 1:
                    aux.addEvento();
                    break;
                case 2:
                    aux.addParticipante();
                    break;
                case 9:
                    a=0;
                    break;

            }
        }
    }


    Scanner sc = new Scanner(System.in);
    public void addEvento() {
        //sc.nextLine();
        print("Nome: ");
        String nome = sc.nextLine();
        print("Titulo: ");
        String titulo = sc.nextLine();
        print("Data de Inicio (dd/MM/aaaa): ");
        String datainicio = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataInicio = LocalDate.parse(datainicio, formatter);//Converte a entrada em um objeto LocalDate
        print("Data de Termino(dd/MM/aaaa): ");
        String datafinal = sc.nextLine();
        LocalDate dataFinal = LocalDate.parse(datafinal, formatter);
        print("Local: ");
        String local = sc.nextLine();
        print("Carga-horária(HH:mm:ss): ");
        String cargaH= sc.nextLine();
        DateTimeFormatter formatter01 = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime ch = LocalTime.parse(cargaH, formatter01);
        print("Descrição: ");
        String descricao = sc.nextLine();
        Evento evento = new Evento(nome, titulo, dataInicio, dataFinal, local, ch,descricao);
        println("Evento cadastrado com sucesso!");
    }

    public void addParticipante(){
        print("Nome: ");
        String nome = sc.nextLine();
        print("CPF: ");
        String cpf = sc.nextLine();
        print("Numero da Matricula: ");
        String matricula = sc.nextLine();
        Participante participante = new Participante(nome, cpf, matricula);
        println("Participante Cadastrado com Sucesso!");
    }
    static void print(String conteudo){System.out.print("\n" + conteudo);}
    static void println(String conteudo){System.out.println(conteudo);}

}
