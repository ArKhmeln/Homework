import java.io.*;
import java.util.*;

public class FilmsCollection implements Serializable {
    private int collectionNumber;
    private Set <Film> filmSet;

    public FilmsCollection (int number, Set <Film> film) {
        collectionNumber = number;
        filmSet = film;
    }

    public void addFilm(Film film) {
        filmSet.add(film);
    }

    public void removeFilm(Film film) {
        if (filmSet.contains(film)) {
            filmSet.remove(film);
        } else {
            System.out.println("There's no such film in this collection");
        }
    }

    public int getCollectionNumber() {
        return collectionNumber;
    }

    public Set<Film> getFilmSet() {
        return filmSet;
    }

    public Set<Actor> showActors(String filmName) {
        int i = 1;
        for (Film f : filmSet) {
            if (f.getFilmTitle().equals(filmName)) {
                return f.getActors();
            } else if (i == filmSet.size()) {
                System.out.println("There's no such film in this collection");
            }
            i++;
        }
        return null;
    }

    public boolean addActorToFilm(String actorName, String filmName) {
        for(Film f : filmSet) {
            if (f.getFilmTitle().equals(filmName)) {
                f.addActor(new Actor(actorName));
                return true;
            }
        }
        System.out.println("There's no such film in this collection");
        return false;
    }

    public boolean deleteActor(String actorName, String filmName) {
        for (Film f : filmSet) {
            if (f.getFilmTitle().equals(filmName)) {
                for (Actor a : f.getActors()) {
                    if (a.getActorName().equals(actorName)) {
                        f.removeActor(actorName);
                        return true;
                    }
                }
            }
        }
        System.out.println("There's no such film or actor in this collection");
        return false;
    }
}
