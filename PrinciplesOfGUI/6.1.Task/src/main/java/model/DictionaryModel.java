package model;

import java.util.HashMap;
import java.util.Map;

public class DictionaryModel {

    private final HashMap<String, String> dictionary;

    public DictionaryModel() {
        this.dictionary = new HashMap<>();
    }

    public boolean isWordInDictionary(String word) {
        if (dictionary.containsKey(word)) {
            return true;
        } else {
            return false;
        }
    }

    public void addWord(String word, String meaning) throws IllegalArgumentException {
        if (dictionary.containsKey(word)) {
            return;
        }
        dictionary.put(word, meaning);
    }

    public String searchWord(String word) throws IllegalArgumentException {
        String value_to_print = "";
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            if (word.equals(entry.getKey())) {
                value_to_print = entry.getValue();
                break;
            }
        }
        return value_to_print;
    }



}
