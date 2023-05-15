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
                    modificarPersona();
                    break;
                case 4:
                    esborrarPersona();
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

        nom = Controlador.demanarDadaAmbRegex("Nom :",".{2,30}");
        cog1 = Controlador.demanarDadaAmbRegex("Primer cognom :",".{2,30}");
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
        personaId = Integer.parseInt(Controlador.demanarDadaAmbRegex("Selecciona una persona introduint el seu id: ", "^\\d+$"));
        for (Persones p: llistaPersones) {
            if (p.getPersona_id() == personaId) {
                PersonesDAODB pdao = new PersonesDAODB(Connexio.getConnexio());
                pdao.delete(p);
                System.out.println("S'ha esborrat la persona: " + p.getFullName());
                return;
            }
        }
        System.out.println("No s'ha pogut esborrar la persona introduida degut a que l'ID introduit no existeix.");
    }
    static void modificarPersona() {
        int personaId;
        ArrayList<Persones> llistaPersones = cercarPersona();
        if (llistaPersones.size() < 1) {
            System.out.println("No s'ha trobat ninguna persona. Vols introduir l'id igualment?");
            if (!Objects.equals(Controlador.demanarDadaAmbRegex("Y/n :", "[Yn]"), "Y")) {
                return;
            }
        }
        personaId = Integer.parseInt(Controlador.demanarDadaAmbRegex("Selecciona una persona introduint el seu id: ", "^\\d+$"));
        System.out.println("Introdueix les dades que vulguis canviar. En cas de no voler modificar, prem intro per continuar.");
        for (Persones p: llistaPersones) {
            if (p.getPersona_id() == personaId) {
                PersonesDAODB pdao = new PersonesDAODB(Connexio.getConnexio());
                String modificacio = Controlador.demanarDadaAmbRegex("Nou nom ("+p.getNom()+") :", ".{2,30}");
                if (modificacio.length() > 0) {
                    p.setNom(modificacio);
                }

                modificacio = Controlador.demanarDadaAmbRegex("Nou Primer cognom ("+p.getCog1()+") :",".{2,30}");
                if (modificacio.length() > 0) {
                    p.setCog1(modificacio);
                }

                modificacio = Controlador.demanarDadaAmbRegex("Now Segon cognom ("+p.getCog2()+") :", ".*");
                if (modificacio.length() > 0) {
                    p.setCog2(modificacio);
                }

                modificacio = Controlador.demanarDadaAmbRegex("Nou Sexe (M, F) ("+p.getSexe()+") :", "^[MF]$");
                if (modificacio.length() > 0) {
                    p.setSexe(modificacio);
                }

                pdao.update(p);
                return;
            }
        }




    }
}
