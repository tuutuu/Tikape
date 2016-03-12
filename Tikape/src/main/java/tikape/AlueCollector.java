
package tikape;

import java.sql.*;

public class AlueCollector implements Collector<Alue> {
    
    @Override
    public Alue collect(ResultSet rs) throws SQLException {
        int alue_id = rs.getInt("alue_id");
        String alueennimi = rs.getString("alueennimi");

        return new Alue(alue_id, alueennimi);
    }
}
