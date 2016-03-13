package tikape;

import java.sql.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Database database = new Database("jdbc:sqlite:vuokraamo.db");
        AlueDao alueDao = new AlueDao(database);
        AvausDao avausDao = new AvausDao(database, alueDao);
        
        
        Alue alue = alueDao.findOne(1);
        System.out.println(alue.getAlue_id() + "-" + alue.getAlueennimi());

    }
}
