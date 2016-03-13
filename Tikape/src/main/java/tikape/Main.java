package tikape;

import java.sql.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Database database = new Database("jdbc:sqlite:Tikape_sqlite.db");
        AlueDao alueDao = new AlueDao(database);
        AvausDao avausDao = new AvausDao(database, alueDao);
        
       
        Avaus avaus = avausDao.findOne(1);
       System.out.println("-" + avaus.getAvausnimi());
     //      Alue alue = alueDao.findOne(1);
    //       System.out.println(alue.getAlueennimi());
    }
}
