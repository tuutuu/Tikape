package tikape;

import java.sql.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Database database = new Database("jdbc:sqlite:Tikape_sqlite.db");
        AlueDao alueDao = new AlueDao(database);
        AvausDao avausDao = new AvausDao(database, alueDao);
        ViestiDao viestiDao = new ViestiDao(database, avausDao);

        List<Viesti> viestit = viestiDao.findAll();
        for (Viesti viesti : viestit) {
            System.out.println(viesti.getAvaus().getAvausnimi() + "-" + viesti.getSisalto() + "-" + viesti.getNimi() + "-" + viesti.getAikaleima());
        }
//     Alue alue = alueDao.findOne(1);
        //     System.out.println(alue.getAlueennimi());
    }
}
