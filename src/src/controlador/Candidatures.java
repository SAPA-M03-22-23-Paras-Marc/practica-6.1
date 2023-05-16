package controlador;

import model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Candidatures {



    public static void menu() throws Exception {
        int opcio;

        do {
            List<String> opcions = Arrays.asList("Cercar Candidatura per ID persona", "Cercar persones per Nom Curt Candidatures", "Enrere");
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

    private static void cercarCandidatura() throws Exception {
        Persones persona_id;

        persona_id = Persona.seleccionarPersona();
        CandidaturesDAODB cdao = new CandidaturesDAODB(Connexio.getConnexio());

        ArrayList<model.Candidatures> llistaCandidatures = cdao.CandidaturaQuery(persona_id);

        vista.Candidatures.mostrarCandidatures(llistaCandidatures);

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


        vista.Persona.mostrarPersones(llistaPersones);
        return llistaPersones;
    }

    private static void cercarPersCandidatures() {
        String nomCandidatura = Controlador.demanarDadaAmbRegex("Nom curt de la candidatura: ", ".*{2,50}");
        PersonesDAODB pdao = new PersonesDAODB(Connexio.getConnexio());
        model.Candidatures candidatura = new model.Candidatures(nomCandidatura);

        ArrayList<Persones> llistaPersones = pdao.getPersonesFromCandidatures(candidatura);
        vista.Persona.mostrarPersones(llistaPersones);
    }
}
