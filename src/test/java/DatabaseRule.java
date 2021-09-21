import org.junit.rules.ExternalResource;
import org.sql2o.*;
public class DatabaseRule extends ExternalResource {

    @Override
    protected void before() {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "alpha", "pw*0711937973");
    }

    @Override
    protected void after() {
        String deleteAnimalsQuery = "DELETE FROM animals *;";
        String deleteEndangeredAnimalsQuery = "DELETE FROM endangered_animals *;";
        String deleteSightingsQuery = "DELETE FROM sightings *;";
        try(Connection con = DB.sql2o.open()) {
            con.createQuery(deleteAnimalsQuery).executeUpdate();
            con.createQuery(deleteEndangeredAnimalsQuery).executeUpdate();
            con.createQuery(deleteSightingsQuery).executeUpdate();
        }
    }
}