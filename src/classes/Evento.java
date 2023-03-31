package classes;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Evento {
    private int ultimoId=  0;
    private int id;
    private String nome;
    private String titulo;
    private LocalDate dataInicio;
    private LocalDate dataFinal;
    private String local;
    private  String descricao;
    Scanner sc = new Scanner(System.in);
    public Evento (String nome, String titulo, LocalDate dataInicio, LocalDate dataFinal, String local, String descricao){
        this.id = ++ultimoId;
        this.nome = nome;
        this.titulo = titulo;
        this.dataInicio=dataInicio;
        this.dataFinal = dataFinal;
        this.local = local;
        this.descricao = descricao;
    }
    public int getId(){return id;}
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
    public void setDescricao(String descricao){this.descricao = descricao;}
    public String getDescricao(){return descricao;}

    public String toString(){
        return "ID do Evento: " + this.id + "\nNome: " + this.nome +"\nTitulo: " + this.titulo
                + "\nData de Inicio: " + this.dataInicio + "\nData de Termino: " + this.dataFinal
                + "\nLocal: " + this.local + "\nDescrição: "+this.descricao + "\n\n";
    }

    public void addEvento() {
        sc.nextLine();
        print("Nome: ");
        String nome = sc.nextLine();
        setNome(nome);
        print("Titulo: ");
        String titulo = sc.nextLine();
        setTitulo(titulo);
        print("Data de Inicio (dd/MM/aaaa): ");
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
        //ch = LocalTime.parse(cargaH, formatter01);
        print("\nDescrição: ");
        descricao = sc.nextLine();

    }
    static void print(String conteudo){System.out.print("\n" + conteudo);}
}