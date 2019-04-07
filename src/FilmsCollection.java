import java.io.*;
import java.util.*;

public class FilmsCollection implements Serializable {
    private int collectionNumber;
    private Set <Film> FilmSet;

    public FilmsCollection (int number, Set <Film> Film) {
        collectionNumber = number;
        FilmSet = Film;
    }

    public void addFilm(Film film) {
        FilmSet.add(film);
    }

    public void removeFilm(Film film) {
        if (FilmSet.contains(film)) {
            FilmSet.remove(film);
        } else {
            System.out.println("There's no such film in this collection");
        }
    }

    public int getCollectionNumber() {
        return collectionNumber;
    }

    public String[] getFilmSet() {
        String[] set = new String[FilmSet.size()];
        int i = 0;
        for (Film f : FilmSet) {
            set[i] = f.getFilmTitle();
            i++;
        }
        return set;
    }

    public String[] showActors(String filmname) {
        int i = 1;
        for (Film f : FilmSet) {
            if (f.getFilmTitle().equals(filmname)) {
                return f.getActors();
            } else if (i == FilmSet.size()) {
                System.out.println("There's no such film in this collection");
            }
            i++;
        }
        return null;
    }

    public void appendActor(String actorname, String filmname) {
        int i = 1;
        for(Film f : FilmSet) {
            if (f.getFilmTitle().equals(filmname)) {
                f.addActor(actorname);
                break;
            } else if (i == FilmSet.size()) {
                System.out.println("There's no such film in this collection");
            }
            i++;
        }
    }

    public void deleteActor(String actorname, String filmname) {
        int i = 1;
        for (Film f : FilmSet) {
            if (f.getFilmTitle().equals(filmname)) {
                for (String a : f.getActors()) {
                    int j = 1;
                    if (a.equals(actorname)) {
                        f.removeActor(actorname);
                        break;
                    } else if (j == f.getActors().length) {
                        System.out.println("There's no such actor, nothing to delete");
                    }
                    j++;
                }
            } else if (i == FilmSet.size()) {
                System.out.println("There's no such film in this collection");
            }
            i++;
        }
    }
}
