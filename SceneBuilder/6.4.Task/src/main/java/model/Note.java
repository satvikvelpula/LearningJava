package model;

public class Note {

    private String note_title;
    private String note_content;

    public Note(String title, String content) {
        this.note_title = title;
        this.note_content = content;
    }

    @Override
    public String toString() {
        return this.note_title + " - " + note_content;
    }

    public String getContent() {return note_content;}
    public String setContent(String content) {return note_content = content;}
    public String getTitle() {return note_title;}
    public String setTitle(String title) {return note_title = title;}
}



