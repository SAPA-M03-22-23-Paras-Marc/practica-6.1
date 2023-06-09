package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Persones {

    int persona_id;
    String nom;
    String cog1;
    String cog2;
    String sexe;
    Date dataNaixement;
    String dni;

    public Persones( String nom, String cog1, String cog2, String sexe, Date dataNaixement, String dni) {
        this.nom = nom;
        this.cog1 = cog1;
        this.cog2 = cog2;
        this.sexe = sexe;
        this.dataNaixement = dataNaixement;
        this.dni = dni;
    }


    public Persones(int persona_id, String nom, String cog1, String cog2, String sexe, Date dataNaixement, String dni) {
        this.persona_id = persona_id;
        this.nom = nom;
        this.cog1 = cog1;
        this.cog2 = cog2;
        this.sexe = sexe;
        this.dataNaixement = dataNaixement;
        this.dni = dni;

    }

    public Persones(int persona_id, String nom, String cog1, String cog2, String sexe, String dataNaixement, String dni) throws ParseException {
        this.persona_id = persona_id;
        this.nom = nom;
        this.cog1 = cog1;
        this.cog2 = cog2;
        this.sexe = sexe;

        this.dataNaixement = new SimpleDateFormat("yyyy-MM-dd").parse(dataNaixement);
        this.dni = dni;
    }

    public Persones(String nom, String cog1, String cog2) {
        this.nom = nom;
        this.cog1 = cog1;
        this.cog2 = cog2;
    }

    public Persones(int persona_id) {
        this.persona_id = persona_id;
    }


    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCog1(String cog1) {
        this.cog1 = cog1;
    }

    public void setCog2(String cog2) {
        this.cog2 = cog2;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getPersona_id() {
        return persona_id;
    }

    public String getNom() {
        return nom;
    }

    public String getCog1() {
        return cog1;
    }

    public String getCog2() {
        return cog2;
    }

    public String getSexe() {
        return sexe;
    }

    public Date getDataNaixement() {
        return dataNaixement;
    }

    public String getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return String.join(" ",nom, cog1, cog2, sexe, dataNaixement.toString(), dni);
    }

    public String getFullName() {
        return String.join(" ", nom, cog1, cog2);
    }




}
