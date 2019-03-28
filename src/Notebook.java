public class Notebook {
    private int lastIndex = 0;
    private final static int DEFAULT_SIZE = 100;
    private final static int CHANGE_SIZE = 50;
    private final static int EMPTY_SIZE_LIMIT = 100;
    public Note [] notes = new Note [DEFAULT_SIZE];

    public void addNote(String note) {
        if (lastIndex > notes.length - 1) {
            increaseSize();
        }
        notes[lastIndex] = new Note(note);
        System.out.println("Note_" + lastIndex + " has been made");
        lastIndex++;
    }

    public void printNotes() {
        System.out.println("Your notes: ");
        for (int i = 0; i < lastIndex; i++) {
            System.out.println("Note_" + i + ": " + notes[i].getNote());
        }
        System.out.println("Notebook's length: " + notes.length);
    }

    public void deleteNote(int index){
        if (notes.length - lastIndex > EMPTY_SIZE_LIMIT) {
            decreaseSize();
        }
        if (index >= 0) {
            if (index <= lastIndex - 1) {
                Note[] copy = new Note[notes.length];
                System.arraycopy(notes, 0, copy, 0, index);
                System.arraycopy(notes, index + 1, copy, index, notes.length - index - 1);
                notes = copy;
                System.out.println("Note_" + index + " has been deleted");
                lastIndex--;
            } else {
                System.out.println("Index note is empty, nothing to delete!");
            }
        } else if (index < 0) {
            System.out.println("Negative index was entered. Please, enter a positive index");
        }
    }

    public void changeNote(int index, String change) {
        if (index < 0) {
            System.out.println("Negative index was entered. Please, enter a positive index");
        } else if (index > notes.length - 1) {
            System.out.println("Index note is out of Notebook's range!");
        } else if (notes[index] == null) {
            System.out.println("Index note is empty, nothing to change!");
        } else {
            notes[index] = new Note(change);
            System.out.println("Note_" + index + " has been changed");
        }
    }

    private void increaseSize() {
        Note [] copy = new Note [notes.length + CHANGE_SIZE];
        System.arraycopy(notes, 0, copy, 0, lastIndex);
        notes = copy;
        System.out.println("Notebook's length has been increased. Notebook's length is now: " + notes.length);
    }

    private void decreaseSize() {
        Note [] copy = new Note [notes.length - CHANGE_SIZE];
        System.arraycopy(notes, 0, copy, 0, lastIndex);
        notes = copy;
        System.out.println("Notebook's length has been reduced. Notebook's length is now: " + notes.length);
    }
}