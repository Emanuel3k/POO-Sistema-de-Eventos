package classes;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Evento {
    private   String nome;
    private String titulo;
    private LocalDate dataInicio;
    private LocalDate dataFinal;
    private String local;

    public LocalTime ch; //Carga Horaria
    public String organizador;//Vai ter que ser uma lista encadeada
    public String descricao;

    public void setNome(String nome){this.nome=nome;}
    public String getNome(){ return nome;}
    public void setTitulo(String titulo){this.titulo=titulo;}
    public String getTitulo(){return titulo;}
    public void setDataInicio(LocalDate dataInicio){this.dataInicio=dataInicio;}
    public LocalDate getDataInicio(){return dataInicio;}
    public void setDataFinal(LocalDate dataFinal){this.dataFinal=dataFinal;}
    public LocalDate getDataFinal(){return dataFinal;}
    public void setLocal(String local){this.local=local;}
    public String getLocal(){return local;}

    public void setCh(LocalTime ch) {this.ch = ch;}

    public LocalTime getCh() {return ch;}

    public void setOrganizador(String organizador) {this.organizador = organizador;}

    public String getOrganizador() {return organizador;}

    public void setDescricao(String descricao) {this.descricao = descricao;}

    public String getDescricao() {return descricao;}
    Scanner sc = new Scanner(System.in);
    public void cadastrarEvento(){
        print("Nome: ");
        nome = sc.nextLine();
        print("\nTitulo: ");
        titulo = sc.nextLine();
        print("\nData de Inicio(dd/MM/aaaa): ");
        String datainicio = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dataInicio = LocalDate.parse(datainicio, formatter);//Converte a entrada em um objeto LocalDate
        print("\nData de Termino(dd/MM/aaaa): ");
        String datafinal = sc.nextLine();
        dataFinal = LocalDate.parse(datafinal, formatter);
        print("\nLocal: ");
        local = sc.nextLine();
        print("\nCarga-horária(HH:mm:ss): ");
        String cargaH= sc.nextLine();
        DateTimeFormatter formatter01 = DateTimeFormatter.ofPattern("HH:mm:ss");
        ch = LocalTime.parse(cargaH, formatter01);
        print("\nOrganizadores: ");
        organizador = sc.nextLine();
        print("\nDescrição: ");
        descricao = sc.nextLine();
    }

    public void mostrarEvento(){
        println("Nome:" + nome);
        println("Titulo: " + titulo);
        println("Data de Inicio: " + dataInicio);
        println("Data de Termino: " + dataFinal);
        println("Local: " + local);
        println("Carga-horária: " + ch);
        println("Organizadores: " + organizador);
        println("Descrição: " + descricao);
    }

    static void println(String conteudo){System.out.println(conteudo);}
    static void print(String conteudo){System.out.print(conteudo);}//função pra não precisar ficar escrevendo System.out.printl
}
