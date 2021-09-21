import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;


public class AnimalTest{

    @Rule
    public DatabaseRule database = new DatabaseRule();

    private Animal testAnimal;
    private Endangered testEndangered;

    @Before
    public void setup(){
        testAnimal = new Animal("Monkey");
        testEndangered =new Endangered("Zebra","Healthy","Young");

    }

    @Test
    public void animal_instantiatesCorrectly_true() {
        assertEquals(true, testAnimal instanceof Animal);
    }

    @Test
    public void getName_animalInstantiatesWithName_Orangutan() {
        assertEquals("Monkey", testAnimal.getName());
    }

    @Test
    public void getId_animalInstantiatesWithId(){
        testAnimal.save();
        assertTrue(testAnimal.getId() > 0);
    }

    @Test
    public void getAge_animalInstantiatesWithAge_Young() {
        assertEquals("Young", testEndangered.getAge());
    }

    @Test
    public void getHealth_animalInstantiatesWithHealth_Healthy() {
        assertEquals("Healthy", testEndangered.getHealth());
    }

    @Test
    public void getType_animalInstantiatesWithType_Type() {
        assertEquals("Non-endangered", testAnimal.getType());
    }

    @Test
    public void equals_returnsTrueIfNamesAreTheSame() {
        Animal anotherAnimal = new Animal("Monkey");
        assertTrue(testAnimal.equals(anotherAnimal));
    }

    @Test
    public void save_assignsIdToObject() {
        testAnimal.save();
        Animal savedAnimal = Animal.all().get(0);
        assertEquals(testAnimal.getId(), savedAnimal.getId());
    }

    @Test
    public void save_insertsObjectIntoDatabase() {
        testAnimal.save();
        assertTrue(Animal.all().get(0).equals(testAnimal));
    }

    @Test
    public void all_returnsAllInstancesOfAnimal_false() {
        testAnimal.save();
        Animal otherAnimal = new Animal("Deer");;
        otherAnimal.save();
        assertEquals(true, Animal.all().get(0).equals(testAnimal));
        assertEquals(true, Animal.all().get(1).equals(otherAnimal));
    }

    @Test
    public void find_returnsAnimalWithSameId() {
        testAnimal.save();
        Animal anotherAnimal = new Animal("Deer");
        anotherAnimal.save();
        assertEquals(Animal.find(anotherAnimal.getId()), anotherAnimal);
    }

    @Test
    public void delete_deletesAnimal() {
        testAnimal.save();
        testAnimal.delete();
        assertEquals(0, Animal.all().size());
    }
}
