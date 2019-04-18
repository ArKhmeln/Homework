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
        int count = 1;
        for (Film films : filmSet) {
            if (films.getFilmTitle().equals(filmName)) {
                return films.getActors();
            } else if (count == filmSet.size()) {
                System.out.println("There's no such film in this collection");
            }
            count++;
        }
        return null;
    }

    public boolean addActorToFilm(String actorName, String filmName) {
        for(Film film : filmSet) {
            if (film.getFilmTitle().equals(filmName)) {
                film.addActor(new Actor(actorName));
                return true;
            }
        }
        System.out.println("There's no such film in this collection");
        return false;
    }

    public boolean deleteActor(String actorName, String filmName) {
        for (Film films : filmSet) {
            if (films.getFilmTitle().equals(filmName)) {
                for (Iterator <Actor> it = films.getActors().iterator(); it.hasNext();) {
                    Actor act = it.next();
                    if (act.getActorName().equals(actorName)) {
                        it.remove();
                        return true;
                    }
                }
            }
        }
        System.out.println("There's no such film or actor in this collection");
        return false;
    }
}
