package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import model.Note;
import model.Notebook;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;

public class Controller {

    private Note note;
    private Notebook noteBook;

    @FXML
    private TextField noteTitle;
    @FXML
    private TextArea noteContent;
    @FXML
    private Button addButton;
    @FXML
    private ListView<Note> displayNotes;

    public Controller() {
        noteBook = new Notebook();
    }

    public void addNote() {
        String title = noteTitle.getText();
        String content = noteContent.getText();
        note = new Note(title, content);
        noteBook.addNote(note);
        displayNotes.getItems().add(note);
        noteTitle.clear();
        noteContent.clear();
    }

    @FXML
    private void editNote() {
        Note selectedNote = displayNotes.getSelectionModel().getSelectedItem();

        if (selectedNote == null) {
            System.out.println("No note selected to edit.");
            return;
        }

        selectedNote.setTitle(noteTitle.getText());
        selectedNote.setContent(noteContent.getText());
        displayNotes.refresh();

        noteTitle.clear();
        noteContent.clear();
    }


    @FXML
    private void deleteNote() {

        Note selectedNote = displayNotes.getSelectionModel().getSelectedItem();

        if (selectedNote != null) {
            noteBook.getNotes().remove(selectedNote);
            displayNotes.getItems().remove(selectedNote);
        }
    }




    @FXML
    public void initialize() {

        displayNotes.getSelectionModel()
                .selectedItemProperty()
                .addListener(new ChangeListener<Note>() {

                    @Override
                    public void changed(ObservableValue<? extends Note> observable,
                                        Note oldValue,
                                        Note newValue) {

                        if (newValue != null) {
                            noteTitle.setText(newValue.getTitle());
                            noteContent.setText(newValue.getContent());
                        }
                    }
                });
    }


}

