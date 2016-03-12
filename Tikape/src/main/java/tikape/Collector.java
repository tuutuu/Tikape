/*Entäpä jos haluaisimme hakea tietokannasta lähes 
minkälaisia olioita tahansa?

Luodaan rajapinta Collector, jonka tehtävänä on 
muuttaa mikä tahansa tulosrivi olioksi. 
Teemme rajapinnasta geneerisen, eli rajapinnalle 
voidaan määritellä luotavan olion tyyppi lennosta.
*/

package tikape;

import java.sql.*;

public interface Collector<T> {
    
    T collect(ResultSet rs) throws SQLException;
    
}
