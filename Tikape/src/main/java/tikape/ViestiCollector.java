
package tikape;

import java.sql.*;

public class ViestiCollector implements Collector<Viesti> {
    
    @Override
    public Viesti collect(ResultSet rs) throws SQLException {
        String nimi = rs.getString("nimi");
        String sisalto = rs.getString("sisalto");
        String aikaleima = rs.getString("aikaleima");

        return new Viesti(nimi, sisalto, aikaleima);
    }
}
