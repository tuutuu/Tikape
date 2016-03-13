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

        Integer avaus_id = rs.getInt("avaus_id");
        String avausnimi = rs.getString("avausnimi");
        String avausteksti = rs.getString("avausteksti");
        String aloitusaika = rs.getString("aloitusaika");

        Avaus a = new Avaus(avaus_id, avausnimi, avausteksti, aloitusaika);

        Integer alue_id = rs.getInt("alue_id");

        rs.close();
        stmt.close();

        a.setAlue(this.alueDao.findOne(alue_id));

        connection.close();

        return a;

    }

    @Override
    public List<Avaus> findAll() throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Avaus");
        ResultSet rs = stmt.executeQuery();

        Map<Integer, List<Avaus>> avaustenAlueet = new HashMap<>();

        List<Avaus> avaukset = new ArrayList<>();

        while (rs.next()) {

        Integer avaus_id = rs.getInt("avaus_id");
        String avausnimi = rs.getString("avausnimi");
        String avausteksti = rs.getString("avausteksti");
        String aloitusaika = rs.getString("aloitusaika");

            Avaus a = new Avaus(avaus_id, avausnimi, avausteksti, aloitusaika);
            avaukset.add(a);

            Integer alue = rs.getInt("alue_id");

            if (!avaustenAlueet.containsKey(alue)) {
                avaustenAlueet.put(alue, new ArrayList<>());
            }
            avaustenAlueet.get(alue).add(a);
        }

        rs.close();
        stmt.close();
      

        for (Alue alue : this.alueDao.findAll()) {
            if (!avaustenAlueet.containsKey(alue.getAlue_id())) {
                continue;
            }

            for (Avaus avaus : avaustenAlueet.get(alue.getAlue_id())) {
                avaus.setAlue(alue);
            }
        } 
        
        connection.close();

        return avaukset;
    }

    @Override
    public void delete(Integer key) throws SQLException {
        // ei toteutettu
    }
}
