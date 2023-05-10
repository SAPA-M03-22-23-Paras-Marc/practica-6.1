package controlador;

import model.Connexio;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void iniciar() {
        Scanner scanner = new Scanner(System.in);
        int opcio = 0;

        Connexio db = new Connexio();
        db.conectar();

        do {
//            System.out.println("Seleccione una opción:");
//            System.out.println("1. Personas");
//            System.out.println("2. Candidatos");
//            System.out.println("3. Candidaturas");
//            System.out.println("0. Salir");
//
//            opcion = scanner.nextInt();
//            opcion = vista.Menu.mostrar()
//            opcio = vista.Menu.mostrar(Arrays.asList("Persones","Candidats", "Candidatures", "Sortir"), scanner);
            List<String> opcions = Arrays.asList("Persones", "Candidats", "Candidatures", "Sortir");
            vista.Menu.mostrar(opcions);
            opcio = escoltarOpcio(opcions, scanner);
//            System.out.println("Has seleccionat el numero : "+ Menu.mostrar(Arrays.asList("Persones","Candidats", "Candidatures")));
//            opcion = Menu.mostrar(Arrays.asList("Opción 1", "Opción 2", "Opción 3"));

//            opcion = 0;
            System.out.println("Has seleccionat el numero " + opcio);
            switch (opcio) {
                case 1:
                    System.out.println("Has seleccionat Persones");
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

        scanner.close();
        db.desconectar();
    }

    static int escoltarOpcio(List<String> opciones, Scanner scanner) {
        int opcion = 0;
        System.out.print("Selecciona una opción: ");
        try {
            opcion = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error: S'ha d'introduir un numero enter..");
            scanner.nextLine();
        }
        return opcion;
    }


//    public static void persones() {
//
//    }

}

