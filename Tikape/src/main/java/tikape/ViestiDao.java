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
    private AvausDao avausDao;

    public ViestiDao(Database database, AvausDao avausDao) {
        this.database = database;
        this.avausDao = avausDao;
    }

    @Override
    public Viesti findOne(Integer key) throws SQLException {
        return null;
    }

    @Override
    public List<Viesti> findAll() throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Viesti");
        ResultSet rs = stmt.executeQuery();

        Map<Integer, List<Viesti>> viestienAvaukset = new HashMap<>();

        List<Viesti> viestit = new ArrayList<>();

        while (rs.next()) {

            String nimi = rs.getString("nimi");
            String sisalto = rs.getString("sisalto");
            String aikaleima = rs.getString("aikaleima");

            Viesti v = new Viesti(nimi, sisalto, aikaleima);
            viestit.add(v);

            Integer avaus = rs.getInt("avaus_id");

            if (!viestienAvaukset.containsKey(avaus)) {
                viestienAvaukset.put(avaus, new ArrayList<>());
            }
            viestienAvaukset.get(avaus).add(v);
        }

        rs.close();
        stmt.close();

        for (Avaus avaus : this.avausDao.findAll()) {
            if (!viestienAvaukset.containsKey(avaus.getAvaus_id())) {
                continue;
            }

            for (Viesti viesti : viestienAvaukset.get(avaus.getAvaus_id())) {
                viesti.setAvaus(avaus);
            }
        }
     connection.close();
        return viestit;
    }

    

    @Override
        public void delete(Integer key) throws SQLException {
        // ei toteutettu
    }
}
