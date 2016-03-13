package tikape;

import java.util.*;
import java.sql.*;

public class AvausDao implements Dao<Avaus, Integer> {

    private Database database;
    private Dao<Alue, Integer> alueDao;

    public AvausDao(Database database, Dao<Alue, Integer> alueDao) {
        this.database = database;
        this.alueDao = alueDao;

    }

    @Override
    public Avaus findOne(Integer key) throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Avaus WHERE avaus_id = ?");
        stmt.setObject(1, key);

        ResultSet rs = stmt.executeQuery();
        boolean hasOne = rs.next();
        if (!hasOne) {
            return null;
        }

        Integer alue_id = rs.getInt("alue_id");
        Integer avaus_id = rs.getInt("avaus_id");
        String avausnimi = rs.getString("avausnimi");
        String avausteksti = rs.getString("avausteksti");
        String aloitusaika = rs.getString("aloitusaika");

        Avaus a = new Avaus(alue_id, avaus_id, avausnimi, avausteksti, aloitusaika);
       
        a.setAlue(this.alueDao.findOne(alue_id));

        rs.close();
        stmt.close();
        connection.close();
        
        return a;

    }

    @Override
    public List<Avaus> findAll() throws SQLException {
        // ei toteutettu
        return null;
    }

    @Override
    public void delete(Integer key) throws SQLException {
        // ei toteutettu
    }
}
