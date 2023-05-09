package controlador;

import model.Connexio;

import java.util.Scanner;

public class Menu {

    public static void iniciar() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        Connexio db = new Connexio();
        db.conectar();

        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Personas");
            System.out.println("2. Candidatos");
            System.out.println("3. Candidaturas");
            System.out.println("0. Salir");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ha seleccionado Personas");
                    // Llamar al método correspondiente para manejar la opción
                    break;
                case 2:
                    System.out.println("Ha seleccionado Candidatos");
                    // Llamar al método correspondiente para manejar la opción
                    break;
                case 3:
                    System.out.println("Ha seleccionado Candidaturas");
                    // Llamar al método correspondiente para manejar la opción
                    break;
                case 0:
                    System.out.println("Fins després!");
                    break;
                default:
                    System.out.println("Opció no válida");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
        db.desconectar();
    }
}

