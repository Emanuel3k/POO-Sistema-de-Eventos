package app;

import classes.Evento;

public class Program {
    public static void main(String[] args) {
     Evento evento = new Evento();
     evento.cadastrarEvento();
     evento.mostrarEvento();
    }
}
