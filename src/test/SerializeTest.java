import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class SerializeTest {

    String pathSave = "D:\\Java\\Projects\\Homework\\src\\Test\\Task2_3_test.txt";
    String pathLoad = "D:\\Java\\Projects\\Homework\\src\\Test\\Task2_3_test.txt";
    Set<Actor> act1 = new HashSet<>();
    Set <Film> fi = new HashSet<>();
    FilmsCollection col1 = new FilmsCollection(1, fi);
    Film f1 = new Film("AI movie", act1);

    @Before
    public void setUp() throws Exception {
        act1.add(new Actor("Bot_1"));
        act1.add(new Actor("Bot_2"));
        col1.addFilm(f1);
    }

    @Test
    public void collectionLoad() {
        Serialize.collectionSave(pathSave, col1);
        FilmsCollection colload = Serialize.collectionLoad(pathLoad);
        assertEquals(col1.getCollectionNumber(), colload.getCollectionNumber());
    }
}