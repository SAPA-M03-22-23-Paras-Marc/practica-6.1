package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonesDAODB {

    private Connection connection;

    public PersonesDAODB(Connection connection) {
        this.connection = connection;
    }

    public void create(Persones persona) throws SQLException {
        String sql = "INSERT INTO persones (persona_id, nom, cog1, cog2) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, persona.getPersona_id());
        statement.setString(2, persona.getNom());
        statement.setString(3, persona.getCog1());
        statement.setString(4, persona.getCog2());
        statement.executeUpdate();
    }

    public List<Persones> read() throws SQLException {
        List<Persones> persones = new ArrayList<>();
        String sql = "SELECT * FROM persones";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int persona_id = resultSet.getInt("persona_id");
            String nom = resultSet.getString("nom");
            String cog1 = resultSet.getString("cog1");
            String cog2 = resultSet.getString("cog2");
            Persones persona = new Persones(persona_id, nom, cog1, cog2);
            persones.add(persona);
        }
        return persones;
    }

    public void update(Persones persona) throws SQLException {
        String sql = "UPDATE persones SET nom=?, cog1=?, cog2=? WHERE persona_id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, persona.getNom());
        statement.setString(2, persona.getCog1());
        statement.setString(3, persona.getCog2());
        statement.setInt(4, persona.getPersona_id());
        statement.executeUpdate();
    }

    public void delete(int persona_id) throws SQLException {
        String sql = "DELETE FROM persones WHERE persona_id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, persona_id);
        statement.executeUpdate();
    }
}

