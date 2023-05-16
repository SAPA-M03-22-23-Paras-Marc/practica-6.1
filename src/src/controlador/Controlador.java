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
        Scanner scanner = Controlador.scanner;
        String valor = null;
        boolean esValid = false;
        while (!esValid) {
            System.out.print(prompt);
            valor = scanner.nextLine();
            esValid = Pattern.matches(regex, valor);
            if (!esValid) {
                System.out.println("El valor introduit no cumpleix el format.");
            }
        }

        return valor;
    }

    public static Date demanarData(String prompt) {
        Date data = null;
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        
        boolean dataValida = false;
        while (!dataValida) {
            String dataString = demanarDadaAmbRegex(prompt,"^((19)|(20))\\d{2}\\-[01]\\d\\-[0-3]\\d$");

            try {
                data = formatoFecha.parse(dataString);
                dataValida = true;
            } catch (ParseException e) {
                System.out.println("Format de data invalid. Introdueix una data en format 'YYYY-MM-DD'.");
            }
        }


        return data;
    }
}
