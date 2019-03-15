public class Notebook {
    private int last_index = 0;
    private final static int DEFAULT_SIZE = 100;
    String [] notes = new String [DEFAULT_SIZE];
    public void addNote(String note) {
        if (last_index > notes.length - 1) {
            String [] copy = new String [notes.length + 50];
            System.arraycopy(notes, 0, copy, 0, last_index);
            notes = copy;
            System.out.println("Notebook's length has been increased. Notebook's length is now: " + notes.length);
        }
        notes[last_index] = note;
        System.out.println("The Note_" + last_index + " has been made");
        last_index++;
    }
    public void printNotes() {
        System.out.println("Your notes: ");
        for (int i = 0; i < last_index; i++) {
            System.out.println("Note_" + i + ": " + notes[i]);
        }
        System.out.println("Notebook's length: " + notes.length);
    }
    public void deleteNote(int index){
        if (notes.length - last_index > 100) {
            String [] copy = new String [notes.length - 50];
            System.arraycopy(notes, 0, copy, 0, last_index);
            notes = copy;
            System.out.println("Notebook's length has been reduced. Notebook's length is now: " + notes.length);
        }
        if (notes[index] != null || index <= last_index - 1) {
            String[] copy = new String[notes.length];
            System.arraycopy(notes, 0, copy, 0, index);
            System.arraycopy(notes, index + 1, copy, index, notes.length - index - 1);
            notes = copy;
            System.out.println("Note_" + index + " has been deleted");
            last_index--;
        }
        else {
            System.out.println("Index note is empty, nothing to delete!");
        }
    }
    public void changeNote(int index, String note) {
        if (index > last_index - 1) {
            System.out.println("Index note is empty, nothing to change!");
        }
        else {
            String change = note;
            notes[index] = change;
            System.out.println("The Note_" + index + " has been changed");
        }
    }
}