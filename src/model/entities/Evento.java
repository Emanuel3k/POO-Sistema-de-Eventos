package model.entities;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Evento {
    // ATRIBUTOS
    private int id;
    private String titulo;
    private String descricao;
    private String local;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private List<String> organizadores;

    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    // CONSTRUTORES
    public Evento(int id, String titulo, String descricao, String local, LocalDateTime inicio, LocalDateTime fim,
            List<String> organizadores) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.local = local;
        this.inicio = inicio;
        this.fim = fim;
        this.organizadores = organizadores;
    }

    // METODOS
    public void cargaHoraria() {
        Duration ch = Duration.between(inicio, fim);
        System.out.println("O Evento irá durar: " + ch.toHours() + " Horas");
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

    public List<String> getOrganizadores() {
        return organizadores;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\t|Titulo: " + titulo + "\t|Descricao: " + descricao + "\t|Local: " + local + "\t|Inicio: "
                + inicio.format(fmt) + "\t|Fim do evento: " + fim.format(fmt) + "\t|Organizadores: " + organizadores;
    }

}