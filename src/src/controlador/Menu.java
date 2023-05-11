package controlador;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void principal() {

        int opcio;

        do {
            List<String> opcions = Arrays.asList("Persones", "Candidats", "Candidatures", "Sortir");
            vista.Menu.mostrar(opcions);
            opcio = escoltarOpcio();

            System.out.println("Has seleccionat el numero " + opcio);
            switch (opcio) {
                case 1:
                    System.out.println("Has seleccionat Persones");
                    Persona.menu();
                    break;
                case 2:
                    System.out.println("Has seleccionat Candidats");
                    break;
                case 3:
                    System.out.println("Has seleccionat Candidatures");
                    break;
                case 0:
                    System.out.println("Fins després!");
                    break;
                default:
                    System.out.println("Opció no válida");
                    break;
            }
        } while (opcio != 0);

    }

    static int escoltarOpcio() {

        Scanner scanner = Controlador.scanner;
        int opcion = 0;
        boolean opcionValida = false;

        while (!opcionValida) {
            try {
                System.out.print("Selecciona una opción: ");
                opcion = Integer.parseInt(scanner.nextLine());
                opcionValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: S'ha d'introduir un numero enter.");
                scanner.nextLine();
            }
        }

        return opcion;
    }


}

