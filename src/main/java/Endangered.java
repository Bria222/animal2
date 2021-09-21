import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;
import java.sql.Timestamp;
// endangered animal extends animal but with new attributes age and health

public class Endangered extends Animal {

    public String health;
    public String age;
    public static final String ANIMAL_TYPE = "Endangered";

    // constructor with animal attributes and new attributes for endangered animal
    public Endangered(String name, String health, String age) {
        super(name);
        if (name.equals("") || health.equals("") || age.equals("")){
            throw new IllegalArgumentException("Please enter all input fields.");
        }
        this.health = health;
        this.age = age;
        type = ANIMAL_TYPE;
    }

    //get methods for endangered animal
    public String getHealth() {
        return health;
    }

    public String getAge() {
        return age;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    //set method for endangered animals age
    public void setAge(String age) {
        this.age = age;
    }

    // overriding endangered animal
    @Override
    public boolean equals(Object otherEndangeredAnimal) {
        if (otherEndangeredAnimal instanceof Endangered) {
            Endangered newEndangeredAnimal = (Endangered) otherEndangeredAnimal;
            return (this.getName().equals(newEndangeredAnimal.getName()));
        }

        return false;
    }


    //Overriding save in animal class for  endangered  class
    @Override
    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name, health, age, type) VALUES (:name, :health, :age, :type)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", name)
                    .addParameter("health", health)
                    .addParameter("age", age)
                    .addParameter("type", type)
                    .executeUpdate()
                    .getKey();
        }
    }

    // finding endangered animal with a static type that will apply to animal class too
    public static Endangered find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals WHERE id = :id";
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(Endangered.class);
        }
    }

    //Overriding update method from Animal class for endangered animal
    @Override
    public void update() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "UPDATE animals SET name = :name, health = :health, age = :age WHERE id = :id";
            con.createQuery(sql)
                    .addParameter("name", name)
                    .addParameter("health", health)
                    .addParameter("age", age)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }


}
