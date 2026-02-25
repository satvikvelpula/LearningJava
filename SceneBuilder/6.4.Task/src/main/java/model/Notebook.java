package model;
import model.Note;

import java.util.ArrayList;

public class Notebook {
    private ArrayList<Note> notebook;

    public Notebook() {
        notebook = new ArrayList<>();
    }

    public void addNote(Note note) {
        notebook.add(note);
    }

    public void getNote(Note note) {
        if (!notebook.contains(note)) {
            System.out.println("Book was not found. ");
            return;
        }
        notebook.remove(note);
        System.out.println(note);
    }

    public ArrayList<Note> getNotes() {
        return notebook;
    }
}