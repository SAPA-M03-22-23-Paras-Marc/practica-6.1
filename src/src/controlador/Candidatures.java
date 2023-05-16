package controlador;

import model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Candidatures {



    public static void menu() {
        int opcio;

        do {
            List<String> opcions = Arrays.asList("Cercar Candidatura per ID persona", "Cercar persones per nom_curt Candidatures", "Enrere");
            vista.Menu.mostrar(opcions);
            opcio = Menu.escoltarOpcio();
            switch (opcio) {
                case 1:
                    cercarCandidatura();
                    break;
                case 2:
                    cercarPersCandidatures();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opció no válida");
                    break;
            }
        } while (opcio != 0);
    }

    private static void cercarCandidatura() {
        int persona_id;

        persona_id = Persona.seleccionarPersona().getPersona_id();
        //persona_id = Integer.parseInt(Controlador.demanarDadaAmbRegex("ID Persona :","\\d+$"));
         //Candidatures ca = new Candidatures(persona_id);
        CandidaturesDAODB cadao = new CandidaturesDAODB(Connexio.getConnexio());
      //  CandidatsDAODB cdao = new CandidatsDAODB(Connexio.getConnexio());
       // ArrayList<Candidats> llistaCandidats = cdao.read(c);
        ArrayList<model.Candidatures> llistaCandidatures = cadao.read();

      /* if(llistaCandidats.size() > 0) {
           System.out.println(llistaCandidats.get(0));
       }

       */

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

    private static void cercarPersCandidatures() {

    }
}
