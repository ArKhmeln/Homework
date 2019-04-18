import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class FilmsCollectionTest {

    Set<Actor> act1 = new LinkedHashSet<>();
    Set <Actor> act2 = new LinkedHashSet<>();
    Set <Film> fi = new LinkedHashSet<>();
    FilmsCollection col1 = new FilmsCollection(1, fi);
    Film f1 = new Film("AI Movie", act1);
    Film f2 = new Film("Mashine", act2);

    @Before
    public void before() {
        act1.add(new Actor("Bot_1"));
        act1.add(new Actor("Bot_2"));
        act2.add(new Actor("Bot_3"));
        act2.add(new Actor("Bot_4"));
        col1.addFilm(f1);
        col1.addFilm(f2);
    }

    @Test
    public void removeFilm() {
        col1.removeFilm(f1);
        assertEquals("[" + f2 + "]", col1.getFilmSet().toString());
    }

    @Test
    public void getFilmSet() {
        String[] expected = {"AI Movie", "Mashine"};
        String[] actual = new String[2];
        int ind = 0;
        for (Film i : col1.getFilmSet()) {
            actual[ind] = i.getFilmTitle();
            ind++;
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void showActors() {
        String[] expected = {"Bot_1", "Bot_2"};
        String[] actual = new String[2];
        int ind = 0;
        for (Actor i : col1.showActors("AI Movie")) {
            actual[ind] = i.getActorName();
            ind++;
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void deleteActor() {
        col1.deleteActor("Bot_3", "Mashine");
        String[] expected = {"Bot_4"};
        String[] actual = new String[expected.length];
        int ind = 0;
        for (Actor i : col1.showActors("Mashine")) {
            actual[ind] = i.getActorName();
            ind++;
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void deleteActorNegative() {
        boolean actual = col1.deleteActor("Bot_3", "Netu");
        assertEquals(false, actual);
    }
}