package tikape;

import java.sql.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Database database = new Database("jdbc:sqlite:Tikape_sqlite.db");
        AlueDao alueDao = new AlueDao(database);
        AvausDao avausDao = new AvausDao(database, alueDao);
        ViestiDao viestiDao = new ViestiDao(database, avausDao);
        Scanner Lukija = new Scanner(System.in);

        /*List<Viesti> viestit = viestiDao.findAll();
        for (Viesti viesti : viestit) {
            System.out.println(viesti.getAvaus().getAlue().getAlueennimi() + "-" + viestit.size() + "-" + "-" + viesti.getAikaleima());
        }*/
        while (true) {
            System.out.println("Anna komento:");
            String komento = Lukija.nextLine();
            if (komento.equals(":/")) {
                break;
            } else {
                System.out.println("Anna merkkijono :/ jatkaaksesi.");
            }
        }
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT Alue.alueennimi AS Alue, COUNT(Viesti.sisalto) AS Viesteja_yhteensa,\n"
                + "MAX(Viesti.aikaleima) AS Viimeisin_viesti FROM Alue LEFT JOIN Avaus ON Alue.alue_id =\n"
                + "Avaus.alue_id LEFT JOIN Viesti ON Viesti.avaus_id=Avaus.avaus_id GROUP BY Alue;");
        ResultSet rs = stmt.executeQuery();
        
        System.out.println("Alue    viestimäärät    viimeinen");
        while (rs.next()) { 
            System.out.println(rs.getString("Alue") + "   " + rs.getInt("Viesteja_yhteensa") + "   " + rs.getString("Viimeisin_viesti"));
        }
        
        rs.close();
        stmt.close();
        connection.close();

    }
}
