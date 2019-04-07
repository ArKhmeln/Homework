import java.util.*;

public class Main2_3 {
    public static void main(String[] args) {
        String pathsave = "D:\\Lessons\\Result\\Task2_3.txt";
        String pathload = "D:\\Lessons\\Result\\Task2_3.txt";
        Set <String> act1 = new HashSet<>();
        act1.add("Bot_1");
        act1.add("Bot_2");
        Set <String> act2 = new HashSet<>();
        act2.add("Bot_3");
        act2.add("Bot_4");
        Set <Film> fi = new HashSet<>();
        FilmsCollection col1 = new FilmsCollection(1, fi);
        Film f1 = new Film("AI movie", act1);
        fi.add(f1);
        Film f2 = new Film("Mashine", act2);
        fi.add(f2);
        for(String i : f1.getActors()) {
            System.out.println(i);
        }
        Serialize.collectionSave(pathsave, col1);
        FilmsCollection colload = Serialize.collectionLoad(pathload);
        for (String i : colload.getFilmSet()) {
            System.out.println(i);
        }
        for (String i : colload.showActors("Mashine")) {
            System.out.println(i);
        }
        colload.appendActor("Bot", "Netu");
        colload.deleteActor("Bot_3", "Mashine");
        for (String i : colload.showActors("Mashine")) {
            System.out.println(i);
        }
    }
}
