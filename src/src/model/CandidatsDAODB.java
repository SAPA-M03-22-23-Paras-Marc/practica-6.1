package model;

import model.Candidats;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CandidatsDAODB {
    private Connection connection;

    public CandidatsDAODB(Connection connection) {
        this.connection = connection;
    }

    public void create(Candidats candidat) throws SQLException {
        String sql = "INSERT INTO candidats (candidat_id, provincia_id, persona_id, candidatura_id, tipus) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, candidat.getCandidat_id());
            statement.setInt(2, candidat.getProvincia_id());
            statement.setInt(3, candidat.getPersona_id());
            statement.setInt(4, candidat.getCandidatura_id());
            statement.setString(5, String.valueOf(candidat.getTipus()));
            statement.executeUpdate();
        }
    }

    public List<Candidats> read() throws SQLException {
        List<Candidats> candidats = new ArrayList<>();
        String sql = "SELECT * FROM candidats";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int candidat_id = resultSet.getInt("candidat_id");
                int provincia_id = resultSet.getInt("provincia_id");
                int persona_id = resultSet.getInt("persona_id");
                int candidatura_id = resultSet.getInt("candidatura_id");
                char tipus = resultSet.getString("tipus").charAt(0);
                Candidats candidat = new Candidats(candidat_id, provincia_id, persona_id, candidatura_id, tipus);
                candidats.add(candidat);
            }
        }
        return candidats;
    }

    public Candidats getById(int id) throws SQLException {
        Candidats candidat = null;
        String sql = "SELECT * FROM candidats WHERE candidat_id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int candidat_id = resultSet.getInt("candidat_id");
                int provincia_id = resultSet.getInt("provincia_id");
                int persona_id = resultSet.getInt("persona_id");
                int candidatura_id = resultSet.getInt("candidatura_id");
                char tipus = resultSet.getString("tipus").charAt(0);
                candidat = new Candidats(candidat_id, provincia_id, persona_id, candidatura_id, tipus);
            }
        }
        return candidat;
    }

    public void update(Candidats candidat) throws SQLException {
        String sql = "UPDATE candidats SET provincia_id=?, persona_id=?, candidatura_id=?, tipus=? WHERE candidat_id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, candidat.getProvincia_id());
            statement.setInt(2, candidat.getPersona_id());
            statement.setInt(3, candidat.getCandidatura_id());
            statement.setString(4, String.valueOf(candidat.getTipus()));
            statement.setInt(5, candidat.getCandidat_id());
            statement.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM candidats WHERE candidat_ide=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1,id);
            statement.executeUpdate();
        }
    }
}