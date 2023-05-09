package model;

public class Candidats {
    int candidat_id, provincia_id, persona_id, candidatura_id;
    char tipus;



    public Candidats(int candidat_id, int provincia_id, int persona_id, int candidatura_id, char tipus){
        this.candidat_id = candidat_id;
        this.provincia_id = provincia_id;
        this.persona_id = persona_id;
        this.candidatura_id = candidatura_id;
        this.tipus = tipus;

    }


    public void setCandidat_id(int candidat_id) {
        this.candidat_id = candidat_id;
    }

    public void setTipus(char tipus) {
        this.tipus = tipus;
    }

    public void setProvincia_id(int provincia_id) {
        this.provincia_id = provincia_id;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }

    public void setCandidatura_id(int candidatura_id) {
        this.candidatura_id = candidatura_id;
    }

    public int getCandidat_id() {
        return candidat_id;
    }


    public int getPersona_id() {
        return persona_id;
    }

    public int getCandidatura_id() {
        return candidatura_id;
    }
    public int getProvincia_id() {
        return provincia_id;
    }

    public char getTipus() {
        return tipus;
    }

}
