package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CandidatsDAODB implements DAODB<Candidats> {

    private Connection connection;

    public CandidatsDAODB(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean create(Candidats c) {
        try {
            String sql = "INSERT INTO candidats (candidat_id, provincia_id, persona_id, candidatura_id, tipus) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, c.getCandidat_id());
            statement.setInt(2, c.getProvincia_id());
            statement.setInt(3, c.getPersona_id());
            statement.setInt(4, c.getCandidatura_id());
            statement.setString(5, String.valueOf(c.getTipus()));
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<Candidats> read(Candidats c) {
        ArrayList<Candidats> llistaCandidats = new ArrayList<Candidats>();
        try {
            String sql = "SELECT * FROM candidats WHERE candidat_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, c.getCandidat_id());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int provincia_id = resultSet.getInt("provincia_id");
                int persona_id = resultSet.getInt("persona_id");
                int candidatura_id = resultSet.getInt("candidatura_id");
                String tipus = resultSet.getString("tipus");
                c.setProvincia_id(provincia_id);
                c.setPersona_id(persona_id);
                c.setCandidatura_id(candidatura_id);
                if (tipus != null && !tipus.isEmpty()) {
                    c.setTipus(tipus.charAt(0));
                }
                return llistaCandidats;
            } else {
                return llistaCandidats;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return llistaCandidats;
        }
    }

    @Override
    public boolean update(Candidats c) {
        try {
            String sql = "UPDATE candidats SET provincia_id=?, persona_id=?, candidatura_id=?, tipus=? WHERE candidat_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, c.getProvincia_id());
            statement.setInt(2, c.getPersona_id());
            statement.setInt(3, c.getCandidatura_id());
            statement.setString(4, String.valueOf(c.getTipus()));
            statement.setInt(5, c.getCandidat_id());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Candidats c) {
        try {
            String sql = "DELETE FROM candidats WHERE candidat_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, c.getCandidat_id());
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean exists(Candidats c) {
        try {
            String sql = "SELECT * FROM candidats WHERE candidat_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, c.getCandidat_id());
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
            String sql = "SELECT COUNT(*) FROM candidats";
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
    public List<Candidats> all() {
        List<Candidats> candidats = new ArrayList<>();
        try {
            String sql = "SELECT * FROM candidats";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int candidat_id = resultSet.getInt("candidat_id");
                int provincia_id = resultSet.getInt("provincia_id");
                int persona_id = resultSet.getInt("persona_id");
                int candidatura_id = resultSet.getInt("candidatura_id");
                String tipus = resultSet.getString("tipus");
                Candidats candidat = new Candidats(candidat_id, provincia_id, persona_id, candidatura_id, tipus.charAt(0));
                candidats.add(candidat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return candidats;
    }
}