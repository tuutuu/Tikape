/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tikape;

import java.util.*;
import java.sql.*;

public class ViestiDao implements Dao<Viesti, Integer> {

    private Database database;
    private Dao<Avaus, String> avausDao;

    public ViestiDao(Database database, Dao<Avaus, String> avausDao) {
        this.database = database;
        this.avausDao = avausDao;
    }

    @Override
    public Viesti findOne(Integer key) throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Viesti, Avaus WHERE avaus_id = ?");
        stmt.setObject(1, key);

        ResultSet rs = stmt.executeQuery();
        boolean hasOne = rs.next();
        if (!hasOne) {
            return null;
        }
        return null;
    }

    @Override
    public List<Viesti> findAll() throws SQLException {
        // ei toteutettu
        return null;
    }

    @Override
    public void delete(Integer key) throws SQLException {
        // ei toteutettu
    }
}
