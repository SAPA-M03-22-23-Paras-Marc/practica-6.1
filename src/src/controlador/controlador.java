package controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Controlador {
    static Scanner scanner;

    public static void generarScanner() {
        scanner = new Scanner(System.in);
    }

    public static void tancarScanner() {
        scanner.close();
    }
    public static String demanarDadaAmbRegex(String prompt, String regex) {

        Scanner scanner = new Scanner(System.in);
        String valor;
        boolean esValid;
        do {
            System.out.print(prompt);
            valor = scanner.nextLine();
            esValid = Pattern.matches(regex, valor);
            if (!esValid) {
                System.out.println("El valor introduit no cumpleix el format.");
            }
        } while (!esValid);

        return valor;
    }

    public static Date demanarData(String prompt) {
        Date data = null;
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        
        boolean dataValida = false;
        while (!dataValida) {
            System.out.print(prompt);
            String dataString = scanner.nextLine();
            try {
                data = formatoFecha.parse(dataString);
                dataValida = true;
            } catch (ParseException e) {
                System.out.println("Formato de fecha inválido. Introduce una fecha en formato 'yyyy-MM-dd'.");
            }
        }


        return data;
    }
}
