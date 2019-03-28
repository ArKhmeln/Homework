import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Notebook note1 = new Notebook();
        Scanner scan = new Scanner(System.in);
/*
        Testing
 */
        note1.addNote(scan.nextLine());
        note1.deleteNote(0);
        note1.addNote(scan.nextLine());
        note1.changeNote(0, "changed");
        note1.printNotes();
        for (int i = 0; i <= 100; i++) {
            note1.addNote("testing note " + i);
        }
        for (int i = 99; i >= 0; i--) {
            note1.deleteNote(i);
        }
        note1.printNotes();
    // Negative
        note1.deleteNote(8);
        note1.deleteNote(-1);
        note1.addNote("new testing note");
        note1.changeNote(3,"This note won't change");
        note1.changeNote(1500, "out of bound");
        note1.changeNote(-1, "Negative index");
        note1.printNotes();
    }
}