package controlador;

import model.Persones;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Persona {
    public static void menu() {
        int opcio;

        do {
            List<String> opcions = Arrays.asList("Crear nou registre", "Cercar registre", "Modificar registre", "Esborrar registre");
            vista.Menu.mostrar(opcions);
            opcio = Menu.escoltarOpcio();
            switch (opcio) {
                case 1:
                    crearPersona();
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

    static void crearPersona() {
//        Scanner scanner = new Scanner(System.in);
        String nom;
        String cog1;
        String cog2;
        String sexe;
        Date dataNaixement;
        String dni;

        nom = Controlador.demanarDadaAmbRegex("Nom :",".{3,30}");
        cog1 = Controlador.demanarDadaAmbRegex("Primer cognom :",".{3,30}");
        cog2 = Controlador.demanarDadaAmbRegex("Segon cognom: ", ".{3,30}");
        sexe = Controlador.demanarDadaAmbRegex("Sexe (M, F): ", "^[MF]$");
        dataNaixement = Controlador.demanarData("Data de naixement (format AAAA-MM-DD): ");
        dni = Controlador.demanarDadaAmbRegex("DNI: ", "^\\d{8}[A-Z]");


        Persones p = new Persones(nom, cog1, cog2, sexe, dataNaixement, dni);

        System.out.println(p);



//        PersonesDAODB pdao = new PersonesDAODB(Connexio.getConnexio());
//        pdao.create()
    }

}
