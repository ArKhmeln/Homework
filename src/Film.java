import java.io.*;
import java.util.*;

public class Film implements Serializable {
    private String FilmTitle;
    private Set <String> actors;

    public Film(String title, Set <String> actors) {
        FilmTitle = title;
        this.actors = actors;
    }

    public void addActor(String name) {
        actors.add(name);
    }

    public void removeActor(String name) {
        if (actors.contains(name)) {
            actors.remove(name);
        } else {
            System.out.println("There's no such actor in this Film");
        }
    }

    public String getFilmTitle() {
        return FilmTitle;
    }

    public String[] getActors() {
        String[] act = actors.toArray(new String[actors.size()]);
        return act;
    }
}
