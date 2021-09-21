import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;
import java.sql.Timestamp;

public class Animal {
    public int id;
    public String name;
    public String type;
    //creating animal with constant non endangered
    public static final String ANIMAL_TYPE = "Non-endangered";

    public Animal(String name){
        if (name.equals("")){
            //throw exception if no name is entered
            throw new IllegalArgumentException("Please enter an animal name.");
        }
        this.name = name;

        type = ANIMAL_TYPE;
    }


    public String getName(){
        return name;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }
    // setting animal name
    public void setName(String name) {
        this.name = name;
    }

    // overriding Animal
    @Override
    public boolean equals(Object otherAnimal) {
        if (otherAnimal instanceof Animal) {
            Animal newAnimal = (Animal) otherAnimal;
            return (this.getName().equals(newAnimal.getName()));
        }

        return false;
    }

    //saving a new animal by their name and type
    public void save() {
        String sql = "INSERT INTO animals (name, type) VALUES (:name, :type)";
        try(Connection con = DB.sql2o.open()) {
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", name)
                    .addParameter("type", type)
                    .throwOnMappingFailure(false)
                    .executeUpdate()
                    .getKey();
        }
    }

    // deleting an animal and a sighting using their Id && throwing  exception incase the id is not mapped
    public void delete() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "DELETE from animals WHERE id = :id";
            con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeUpdate();
            String sql2 = "DELETE from sightings WHERE animal_id = :id";
            con.createQuery(sql2)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeUpdate();
        }
    }

    //Listing all animals from animals table
    public static List<Animal> all() {
        String sql = "SELECT * FROM animals;";

        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Animal.class);
        }
    }

    //finding an animal using its id && throwing  exception incase the id is not mapped
    public static Animal find(int id) {
        String sql = "SELECT * FROM animals WHERE id = :id;";

        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(Animal.class);
        }
    }

    //updating an animal using its Id && throwing an exception incase it is not mapped
    public void update() {
        String sql = "UPDATE animals SET name = :name WHERE id = :id";

        try(Connection con = DB.sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("name", name)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeUpdate();
        }
    }
}
