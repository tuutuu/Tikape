
package tikape;

import java.sql.*;

public class ViestiCollector implements Collector<Viesti> {
    
    @Override
    public Viesti collect(ResultSet rs) throws SQLException {
        String nimi = rs.getString("nimi");
        int avaus_id = rs.getInt("avaus_id");
        String sisalto = rs.getString("sisalto");
        String aikaleima = rs.getString("aikaleima");

        return new Viesti(nimi, avaus_id, sisalto, aikaleima);
    }
}
