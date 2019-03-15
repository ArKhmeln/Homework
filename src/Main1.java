import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Notebook note1 = new Notebook();
        Scanner scan = new Scanner(System.in);
/*
        Testing
 */
        Note input = new Note(scan.nextLine());
        note1.addNote(input.getNote());
        note1.deleteNote(0);
        input = new Note(scan.nextLine());
        note1.addNote(input.getNote());
        input = new Note(scan.nextLine());
        note1.changeNote(0, input.getNote());
        note1.printNotes();

        for (int i = 0; i <= 100; i++) {
            input = new Note("testing note " + i);
            note1.addNote(input.getNote());
        }
        for (int i = 99; i >= 0; i--) {
            note1.deleteNote(i);
        }
        note1.printNotes();

        note1.deleteNote(8);
        input = new Note("testing note new");
        note1.addNote(input.getNote());
        input = new Note("This note won't change");
        note1.changeNote(3, input.getNote());
        note1.printNotes();
    }
}