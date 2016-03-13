/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tikape;

import java.util.*;
import java.sql.*;

public class AlueDao implements Dao<Alue, Integer> {

    private Database database;

    public AlueDao(Database database) {
        this.database = database;
    }

    @Override
    public Alue findOne(Integer key) throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Alue WHERE alue_id = ?");
        stmt.setObject(1, key);

        ResultSet rs = stmt.executeQuery();
        boolean hasOne = rs.next();
        if (!hasOne) {
            return null;
        }
        Integer alue_id = rs.getInt("alue_id");
        String alueennimi = rs.getString("alueennimi");

        Alue a = new Alue(alue_id, alueennimi);

        rs.close();
        stmt.close();
        connection.close();
        
        return a;
    }

    @Override
    public List<Alue> findAll() throws SQLException {
        // ei toteutettu
        return null;
    }

    @Override
    public void delete(Integer key) throws SQLException {
        // ei toteutettu
    }
}
