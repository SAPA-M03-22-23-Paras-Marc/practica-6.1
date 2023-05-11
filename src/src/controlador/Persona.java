package controlador;

import model.Connexio;
import model.Persones;
import model.PersonesDAODB;

import java.util.*;

public class Persona {
    public static void menu() {
        int opcio;

        do {
            List<String> opcions = Arrays.asList("Crear nou registre", "Cercar registre", "Modificar registre", "Esborrar registre", "Enrere");
            vista.Menu.mostrar(opcions);
            opcio = Menu.escoltarOpcio();
            switch (opcio) {
                case 1:
                    crearPersona();
                    break;
                case 2:
                    cercarPersona();
                    break;
                case 3:
                    System.out.println("Has seleccionat modificar");
                    break;
                case 4:
                    System.out.println("Has seleccionat esborrar");
                    break;
                case 0:
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
        cog2 = Controlador.demanarDadaAmbRegex("Segon cognom :", ".*");
        sexe = Controlador.demanarDadaAmbRegex("Sexe (M, F) :", "^[MF]$");
        dataNaixement = Controlador.demanarData("Data de naixement (format AAAA-MM-DD) :");
        dni = Controlador.demanarDadaAmbRegex("DNI :", "^\\d{8}[A-Z]");

        Persones p = new Persones(nom, cog1, cog2, sexe, dataNaixement, dni);

        System.out.println(p);

        PersonesDAODB pdao = new PersonesDAODB(Connexio.getConnexio());
        if (pdao.create(p)) {
            System.out.println("S'ha introduit una nova persona correctament.");
        } else {
            System.out.println("S'ha produit un error a l'hora d'introduir una nova persona.");
        }
    }

    static ArrayList<Persones> cercarPersona() {
        String nom;
        String cog1;
        String cog2;

        nom = Controlador.demanarDadaAmbRegex("Nom :",".{3,30}");
        cog1 = Controlador.demanarDadaAmbRegex("Primer cognom :",".{3,30}");
        cog2 = Controlador.demanarDadaAmbRegex("Segon cognom :", ".*");
        Persones p = new Persones(nom, cog1, cog2);
        PersonesDAODB pdao = new PersonesDAODB(Connexio.getConnexio());

        ArrayList<Persones> llistaPersones = pdao.read(p);
//        System.out.println(llistaPersones);

        vista.Persona.mostrarPersones(llistaPersones);
        return llistaPersones;
    }

    static void esborrarPersona() {
        int personaId;
        ArrayList<Persones> llistaPersones = cercarPersona();
        if (llistaPersones.size() < 1) {
            System.out.println("No s'ha trobat ninguna persona. Vols introduir l'id igualment?");
            if (!Objects.equals(Controlador.demanarDadaAmbRegex("Y/n :", "[Yn]"), "Y")) {
                return;
            }

        }
        personaId = Integer.parseInt(Controlador.demanarDadaAmbRegex("ID: ", "^\\d+$"));
    }

}
