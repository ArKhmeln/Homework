import java.util.*;

public class Main2_3 {
    public static void main(String[] args) {
        String pathSave = "D:\\Java\\Projects\\Homework\\src\\Test\\Task2_3.txt";
        String pathLoad = "D:\\Java\\Projects\\Homework\\src\\Test\\Task2_3.txt";
        Set <Actor> act1 = new HashSet<>();
        act1.add(new Actor("Bot_1"));
        act1.add(new Actor("Bot_2"));
        Set <Actor> act2 = new HashSet<>();
        act2.add(new Actor("Bot_3"));
        act2.add(new Actor("Bot_4"));
        Set <Film> fi = new HashSet<>();
        FilmsCollection col1 = new FilmsCollection(1, fi);
        Film f1 = new Film("AI movie", act1);
        fi.add(f1);
        Film f2 = new Film("Mashine", act2);
        fi.add(f2);
        for(Actor i : f1.getActors()) {
            System.out.println(i.getActorName());
        }
        Serialize.collectionSave(pathSave, col1);
        FilmsCollection colload = Serialize.collectionLoad(pathLoad);
        for (Film i : colload.getFilmSet()) {
            System.out.println(i.getFilmTitle());
        }
        for (Actor i : colload.showActors("Mashine")) {
            System.out.println(i.getActorName());
        }
        colload.addActorToFilm("Bot", "Netu");
        colload.deleteActor("Bot_3", "Mashine");
        for (Actor i : colload.showActors("Mashine")) {
            System.out.println(i.getActorName());
        }
    }
}
