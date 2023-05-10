package vista;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void mostrar(List<String> opciones) {
//    public static int mostrar(List<String> opciones, Scanner scanner) {
        for (int i = 0; i < opciones.size(); i++) {
            if (i == opciones.size()-1) {
                System.out.println(0 + ". " + opciones.get(i));
            } else {
                System.out.println((i + 1) + ". " + opciones.get(i));
            }
        }

//        int opcion = 0;
//        boolean opcionValida = false;
//        do {
//            System.out.print("Seleccione una opción: ");
//            try {
//                opcion = scanner.nextInt();
//                opcionValida = opcion >= 0 && opcion <= opciones.size();
//            } catch (InputMismatchException e) {
//                System.out.println("Error: debe ingresar un número entero.");
//                scanner.nextLine();
//            }
//        } while (!opcionValida);
//
//        return opcion;
    }
}
