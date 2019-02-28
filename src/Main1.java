import java.util.Scanner;

class Notebook {
    Scanner scan = new Scanner(System.in);
    int LastIndex = 0;
    final static int DefaultSize = 30;
    String [] notes = new String [DefaultSize];
    void addNote() {
        System.out.println("Make a Note" + LastIndex + ": ");
        if (LastIndex <= notes.length - 1) {
            Note input = new Note(scan.nextLine());
            notes[LastIndex] = input.getNote();
            LastIndex++;
        }
        else {
            System.out.println("Sorry, free space is over :(");
        }
    }
    void checkNotes() {
        System.out.println("Your notes: ");
        for (int i = 0; i < LastIndex; i++) {
            System.out.println("Note" + i + ": " + notes[i]);
        }
    }
    void deleteNote() {
        System.out.println("Enter the note index you want to delete: ");
        int index = scan.nextInt();
        if (index > LastIndex - 1) {
            System.out.println("Index note is empty, nothing to delete!");
        }
        else {
            String [] copy = new String[notes.length - 1];
            System.arraycopy(notes, 0, copy, 0, index);
            System.arraycopy(notes, index + 1, copy, index, notes.length - index - 1);
            notes = copy;
            LastIndex--;
        }
    }
    void changeNote() {
        System.out.println("Enter the note index you want to change: ");
        int index = scan.nextInt();
        if (index > LastIndex - 1) {
            System.out.println("Index note is empty, nothing to change!");
        }
        else {
            System.out.println("Change Note" + index + ": ");
            scan.nextLine();
            String change = scan.nextLine();
            notes[index] = change;
        }
    }
}
class Note {
    String note = "";
    Note (String input) {
        note = input;
    }
    String getNote() {
        return note;
    }
}
public class Main1 {
    public static void main(String[] args) {
        Notebook note = new Notebook();
        note.addNote();
        note.addNote();
        note.addNote();
        note.addNote();
        note.changeNote();
        note.checkNotes();
        note.deleteNote();
        note.checkNotes();
    }
}
