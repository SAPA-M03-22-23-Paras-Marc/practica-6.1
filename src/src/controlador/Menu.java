package controlador;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void principal() throws Exception {

        int opcio;

        do {
            List<String> opcions = Arrays.asList("Persones","Candidatures", "Sortir");
            vista.Menu.mostrar(opcions);
            opcio = escoltarOpcio();

            switch (opcio) {
                case 1:
                    System.out.println("Has seleccionat Persones");
                    Persona.menu();
                    break;
                case 2:
                    System.out.println("Has seleccionat Candidatures");
                    Candidatures.menu();
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
            } catch (NumberFormatException e) {
                return -1;
            }
        }


        return opcion;
    }


}

