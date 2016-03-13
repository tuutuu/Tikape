
package tikape;

import java.sql.*;

public class AvausCollector implements Collector<Avaus> {
    
    @Override
    public Avaus collect(ResultSet rs) throws SQLException {
        int avaus_id = rs.getInt("avaus_id");
        int alue_id = rs.getInt("alue_id");
        String avausnimi = rs.getString("avausnimi");
        String avausteksti = rs.getString("avausteksti");
        String aloitusaika = rs.getString("aloitusaika");
        
        return new Avaus(avaus_id, avausnimi, avausteksti, aloitusaika);
    }
}
