import org.junit.Before;
import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class FilmTest {

    Set<Actor> act1 = new LinkedHashSet<>();
    Film testFilm = new Film("TestMovie", act1);

    @Before
    public void before() {
        act1.add(new Actor("Bot_1"));
        act1.add(new Actor("Bot_2"));
    }

    @Test
    public void removeActor() {
        testFilm.removeActor("Bot_1");
        int actual = testFilm.getActors().size();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void getActors() {
        String[] expected = {"Bot_1", "Bot_2"};
        String[] actual = new String[2];
        int ind = 0;
        for (Actor i : testFilm.getActors()) {
            actual[ind] = i.getActorName();
            ind++;
        }
        assertArrayEquals(expected, actual);
    }
}