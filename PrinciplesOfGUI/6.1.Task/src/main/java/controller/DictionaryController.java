package controller;
import view.DictionaryGUI;
import model.DictionaryModel;
import javax.swing.*;
import java.awt.*;
import java.util.*;


public class DictionaryController {
    private DictionaryGUI gui;
    private DictionaryModel model;
    ArrayList<String> dictionary_keys;
    ArrayList<String> dictionary_values;
    int threshold;
    private int iterable;
    boolean populated = false;

    public DictionaryController(DictionaryGUI gui) {
        this.gui = gui;
        this.model = new DictionaryModel();
        this.dictionary_keys = new ArrayList<>(Arrays.asList("apple", "java", "dictionary", "algorithm", "thread", "model", "controller", "interface", "exception", "hashmap", "object", "class", "inheritance", "polymorphism", "encapsulation"));
        this.dictionary_values = new ArrayList<>(Arrays.asList("a round fruit with red or green skin", "a high-level programming language", "a reference book containing words and meanings", "a step-by-step procedure for solving a problem", "a unit of execution in concurrent programming", "the data and business logic in an application", "handles input and coordinates between model and view", "a contract that defines method signatures", "an event that disrupts normal program flow", "a data structure that stores key-value pairs", "an instance of a class", "a blueprint for creating objects", "a mechanism where one class acquires another's behavior", "the ability of an object to take many forms", "bundling data with methods that operate on it"));
        threshold = dictionary_keys.size();
    }

    // EventHandler<ActionEvent> button_event = actionEvent -> controller.search();
    // Event handler button_event for searching the word

    public void search() {
        iterable++;
        if (gui.getUserInput().getText().trim().isEmpty()) {
            System.out.println("User Input empty." + " Search button clicked (" + iterable + ") times. (CONTROLLER OUTPUT)");
            gui.getDebugResult().setText("Empty");
            gui.getResult().setText("");
            return;
        }

        if (!populated) {
            gui.getDebugResult().setText("Dictionary not populated.");
            gui.getResult().setText("");
            return;
        }

        if (!model.isWordInDictionary(gui.getUserInput().getText().toLowerCase().trim()) /* !model.getDictionary().containsKey(gui.getUserInput().getText().trim()) */) {
            gui.getDebugResult().setText("Invalid");
            gui.getResult().setText("");
            return;
        }


        String func = model.searchWord(gui.getUserInput().getText().toLowerCase().trim());
        System.out.println(func);
        gui.getResult().setText(func);
        gui.getDebugResult().setText("");

    }

    public void populate() {

        if (!populated) {

            for (int i = 0; i < threshold; i++) {
                String list_key_iterable = dictionary_keys.get(i);
                String list_value_iterable = dictionary_values.get(i);
                model.addWord(list_key_iterable, list_value_iterable);
            }

            gui.getDebugResult().setText("Dictionary populated. ");
            gui.getResult().setText("");
            System.out.println("Dictionary populated. ");
            populated = true;

        } else {
            gui.getDebugResult().setText("Dictionary already populated. ");
            gui.getResult().setText("");
            // populated is already true
        }

    }


}
