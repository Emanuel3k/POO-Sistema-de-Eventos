package app;

import java.util.Scanner;

import model.Usuario;

public class Program {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            Ui.clearScreen();

            Usuario user = new Usuario("ROOT");
            login(sc);

            while (true) {
                menu();
                int op = sc.nextInt();

                switch (op) {
                    case 0: // SAIR
                        Ui.clearScreen();
                        System.exit(0);
                        break;

                    case 1: // CADASTRAR EVENTO
                        user.cadEvento();
                        break;

                    case 2: // GERENCIAR EVENTO
                        user.gerirEvento();
                        break;

                    case 3:
                        user.editarEvento();
                        break;
                    case 4: // LISTAR EVENTO
                        user.listarEvento();
                        break;

                    case 5: // REMOVER EVENTO
                        user.rmvEvento();
                        break;

                    default:
                        System.out.println("Operação nao disponivel.\nTente novamente.");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void menu() {
        System.out.println("0 - Sair");
        System.out.println("1 - Cadastrar evento");
        System.out.println("2 - Gerenciar evento");
        System.out.println("3 - Editar informação do evento");
        System.out.println("4 - Listar eventos");
        System.out.println("5 - Cancelar evento");
    }

    public static void login(Scanner sc) {

        for (int i = 0; i <= 10; i++) {
            Ui.clearScreen();
            if (i >= 3) {
                System.out.println("DICA:\nUsuário com todas as permissões do sistema.\n");
            }

            System.out.print("Username: ");
            String login = sc.nextLine().toUpperCase();

            if (login.equals("ROOT")) {
                Ui.clearScreen();
                System.out.println("Login realizado com sucesso!");
                Ui.clearScreen();
                return;
            }
        }
        Ui.clearScreen();
        System.out.println("Tente novamente em alguns segundos.\n");
        System.exit(0);
    }
}