package model;

import java.util.List;

public class CandidatsDAODB implements DAODB<Candidats>{

    @Override
    public boolean create(Candidats c) {
        String query = "INSERT INTO " + taula + " (id,nom,dn,dep) VALUES (?,?,?,?)";
        int r = SQLRW.write(query, c.getProvincia_id(),c.getPersona_id(),c.getCandidatura_id(), c.getNom(), c.getCog1(), c.getCog2());
        return r > 0;
    }

    @Override
    public boolean read(Candidats c) {
       /* Candidats er = read(c.getCandidatura_id());
        if (er == null) return false;
        c.set(er.getNom(), er.getDn(), er.getDep());
        return true; */
    }

    @Override
    public boolean update(Candidats c) {
        String query = "UPDATE " + taula + " SET nom=?,dn=?,dep=? WHERE id=?";
        int r = SQLRW.write(query, c.getProvincia_id(),c.getPersona_id(),c.getCandidatura_id(), c.getNom(), c.getCog1(), c.getCog2());
        return r > 0;
    }

    @Override
    public boolean delete(Candidats c) {
        String query = "DELETE FROM " + taula + " WHERE candidatura_id=?";
        int r = SQLRW.write(query, c.getCandidatura_id());
        return r > 0;
    }

    @Override
    public boolean exists(Candidats candidats) {
        return false;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public List<Candidats> all() {
        return null;
    }
}
