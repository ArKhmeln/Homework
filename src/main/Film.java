import java.io.*;
import java.util.*;

public class Film implements Serializable {
    private String filmTitle;
    private Set <Actor> actors;

    public Film(String title, Set <Actor> actors) {
        filmTitle = title;
        this.actors = actors;
    }

    public void addActor(Actor name) {
        actors.add(name);
    }

    public boolean removeActor(String name) {
        for (Actor a: actors) {
            if (a.getActorName().equals(name)) {
                actors.remove(a);
                return true;
            }
        }
        System.out.println("There's no such actor in this Film");
        return false;
    }

    public String getFilmTitle() {
        return filmTitle;
    }

    public Set<Actor> getActors() {
        return actors;
    }
}
