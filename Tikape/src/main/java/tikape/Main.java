package tikape;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:vuokraamo.db");

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Pyora;");

        while (rs.next()) {
            String rekisterinumero = rs.getString("rekisterinumero");
            String merkki = rs.getString("merkki");

            System.out.println(rekisterinumero + " " + merkki);
        }

        stmt.close();
        rs.close();

        connection.close();
    }
}
