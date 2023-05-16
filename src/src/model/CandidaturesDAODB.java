package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CandidaturesDAODB implements DAODB<Candidatures> {

    private Connection connection;

    public CandidaturesDAODB(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean create(Candidatures ca) {
        try {
            String sql = "INSERT INTO candidatures (candidatura_id, eleccio_id, codi_candidatura, nom_curt, nom_llarg, codi_acumulacio_provincia, codi_acumulacio_ca, codi_acumulacio_nacional) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, ca.getCandidatura_id());
            statement.setInt(2, ca.getEleccio_id());
            statement.setInt(3, ca.getCodi_candidatura());
            statement.setString(4, ca.getNom_curt());
            statement.setString(5, ca.getNom_llarg());
            statement.setInt(6, ca.getCodi_acumulacio_provincia());
            statement.setInt(7, ca.getCodi_acumulacio_ca());
            statement.setInt(8, ca.getCodi_acumulacio_nacional());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<Candidatures> read(Candidatures ca) {
        ArrayList<Candidatures> llistaCandidatures = new ArrayList<Candidatures>();

        try {
            String sql = "SELECT * FROM candidatures WHERE candidatura_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, ca.getCandidatura_id());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int eleccio_id = resultSet.getInt("eleccio_id");
                int codi_candidatura = resultSet.getInt("codi_candidatura");
                String nom_curt = resultSet.getString("nom_curt");
                String nom_llarg = resultSet.getString("nom_llarg");
                int codi_acumulacio_provincia = resultSet.getInt("codi_acumulacio_provincia");
                int codi_acumulacio_ca = resultSet.getInt("codi_acumulacio_ca");
                int codi_acumulacio_nacional = resultSet.getInt("codi_acumulacio_nacional");
                ca.setEleccio_id(eleccio_id);
                ca.setCodi_candidatura(codi_candidatura);
                ca.setNom_curt(nom_curt);
                ca.setNom_llarg(nom_llarg);
                ca.setCodi_acumulacio_provincia(codi_acumulacio_provincia);
                ca.setCodi_acumulacio_ca(codi_acumulacio_ca);
                ca.setCodi_acumulacio_nacional(codi_acumulacio_nacional);
                return llistaCandidatures;
            } else {
                return llistaCandidatures;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return llistaCandidatures;
        }
    }

    @Override
    public boolean update(Candidatures ca) {
        try {
            String sql = "UPDATE candidatures SET eleccio_id=?, codi_candidatura=?, nom_curt=?, nom_llarg=?, codi_acumulacio_provincia=?, codi_acumulacio_ca=?, codi_acumulacio_nacional=? WHERE candidatura_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, ca.getEleccio_id());
            statement.setInt(2, ca.getCodi_candidatura());
            statement.setString(3, ca.getNom_curt());
            statement.setString(4, ca.getNom_llarg());
            statement.setInt(5, ca.getCodi_acumulacio_provincia());
            statement.setInt(6, ca.getCodi_acumulacio_ca());
            statement.setInt(7, ca.getCodi_acumulacio_nacional());
            statement.setInt(8, ca.getCandidatura_id());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Candidatures ca) {
        try {
            String sql = "DELETE FROM candidatures WHERE candidatura_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, ca.getCandidatura_id());
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean exists(Candidatures ca) {
        try {
            String sql = "SELECT * FROM candidatures WHERE candidatura_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, ca.getCandidatura_id());
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int count() {
        try {
            String sql = "SELECT COUNT(*) FROM candidatures";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Candidatures> all() {
        List<Candidatures> candidatures = new ArrayList<>();
        try {
            String sql = "SELECT * FROM candidatures";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int candidatura_id = resultSet.getInt("candidatura_id");
                int eleccio_id = resultSet.getInt("eleccio_id");
                int codi_candidatura = resultSet.getInt("codi_candidatura");
                String nom_curt = resultSet.getString("nom_curt");
                String nom_llarg = resultSet.getString("nom_llarg");
                int codi_acumulacio_provincia = resultSet.getInt("codi_acumulacio_provincia");
                int codi_acumulacio_ca = resultSet.getInt("codi_acumulacio_ca");
                int codi_acumulacio_nacional = resultSet.getInt("codi_acumulacio_nacional");
                Candidatures candidatura = new Candidatures(candidatura_id, eleccio_id, codi_candidatura, nom_curt, nom_llarg, codi_acumulacio_provincia, codi_acumulacio_ca, codi_acumulacio_nacional);
                candidatures.add(candidatura);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return candidatures;
    }

    public static ArrayList<Candidatures> CandidaturaQuery(Persones persona_id) throws Exception {
        ArrayList<Candidatures> Candidatura = new ArrayList<>();

        try {

            String sql = "SELECT *\n" +
                    " FROM candidatures\n" +
                    "INNER JOIN candidats ON candidats.candidatura_id = candidatures.candidatura_id\n" +
                    "INNER JOIN persones ON persones.persona_id = candidats.persona_id \n" +
                    "WHERE persones.persona_id = ? ";

            PreparedStatement statement = Connexio.getConnexio().prepareStatement(sql);
            statement.setInt(1, persona_id.getPersona_id());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int candidatura_id = resultSet.getInt("candidatura_id");
                int eleccio_id = resultSet.getInt("eleccio_id");
                int codi_candidatura = resultSet.getInt("codi_candidatura");
                String nom_curt = resultSet.getString("nom_curt");
                String nom_llarg = resultSet.getString("nom_llarg");
                int codi_acumulacio_provincia = resultSet.getInt("codi_acumulacio_provincia");
                int codi_acumulacio_ca = resultSet.getInt("codi_acumulacio_ca");
                int codi_acumulacio_nacional = resultSet.getInt("codi_acumulario_nacional");
                Candidatures candidatura = new Candidatures(candidatura_id, eleccio_id, codi_candidatura, nom_curt, nom_llarg, codi_acumulacio_provincia, codi_acumulacio_ca, codi_acumulacio_nacional);
                Candidatura.add(candidatura);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Candidatura;
    }

}



