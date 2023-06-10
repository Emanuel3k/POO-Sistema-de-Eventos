package app;

public class Ui {
    /*
     * https://stackoverflow.com/question/2979383/java-clear-the-console
     * Metodo para limpar o terminal
    */
    public static void clearScreen() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
}
