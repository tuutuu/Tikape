package tikape;

import java.sql.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Database database = new Database("jdbc:sqlite:Tikape_sqlite.db");
        database.setDebugMode(true);
        
//     database.update("INSERT INTO Avaus (avaus_id, alue_id, avausnimi, avausteksti, aloitusaika) VALUES (4, 2, 'Onks ohjelmointi vaikeeta?', 'Onko?', CURRENT_TIMESTAMP)");
        
        List<Avaus> avaukset = database.queryAndCollect("SELECT * FROM Avaus", new AvausCollector());

        for (Avaus avaus : avaukset) {
            System.out.println(avaus.getAvausnimi());
        }
    }
}
