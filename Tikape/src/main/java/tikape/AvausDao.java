package tikape;

import java.util.*;
import java.sql.*;

public class AvausDao implements Dao<Avaus, Integer> {
<<<<<<< HEAD

    private Database database;
    private Dao<Alue, Integer> alueDao;

    public AvausDao(Database database, Dao<Alue, Integer> alueDao) {
        this.database = database;
        this.alueDao = alueDao;

    }
=======
>>>>>>> 850dfdcba69bd72775e5571fb5461e6b811a1638

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
       
        Integer alue = rs.getInt("alue");
        
        rs.close();
        stmt.close();
        connection.close();

     //   a.setAlue(this.alueDao.findOne(alue));
        
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
