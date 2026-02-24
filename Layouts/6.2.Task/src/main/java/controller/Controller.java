package controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.ExchangeRate;
import view.GUI;

import java.math.BigDecimal;
import java.util.*;

public class Controller {

    private GUI gui;
    private ExchangeRate model;
    private String base_template;

    public Controller(GUI controller_gui) {
        this.gui = controller_gui;
        this.base_template = "EUR";
        this.model = new ExchangeRate();
    }

    public List<String> fetchCodes() throws Exception {
        model.fetchData(base_template.trim().toUpperCase());
        List<String> codes = new ArrayList<>();
        // List<String> test = new ArrayList<>();
        for (String currency_code : model.getAllCurrencyCodes()) {
            try {
                Currency currency = Currency.getInstance(currency_code); // used for getting the currency display name of currency code
                String currency_name = currency.getDisplayName();

                // codes.add(currency_code);
                codes.add(currency_code + " - " + currency_name);
            } catch (IllegalArgumentException e) {
                System.out.println("Not valid ISO 4217 " + currency_code);
            }
        }
        System.out.println(codes);
        Collections.sort(codes);
        // System.out.println(test);
        return codes;
    }

    /*
        public List<String> fetchCodes() throws Exception {
        model.fetchData(base_template.trim().toUpperCase());
        List<String> codes = new ArrayList<>(model.getAllCurrencyCodes());
        for (String code : codes) {
            try {
                Currency currency = Currency.getInstance(code);
                System.out.println(currency.getDisplayName());
            } catch (IllegalArgumentException e) {
                System.out.println("Not valid ISO 4217");
            }
        }
        return codes;
        fetchCodes() SAVE -> 14.49 23.2
    }
     */

    public void populateComboBox(ComboBox<String> provided_combo_box, List<String> provided_codes) throws Exception {
        if (provided_codes == null || provided_codes.isEmpty()) {return;}
        if (provided_combo_box == null) {return;}
        ObservableList<String> observable = FXCollections.observableArrayList(provided_codes);
        provided_combo_box.setItems(observable);
    }

    public void initialize() throws Exception {
        List<String> fetched = fetchCodes();
        this.populateComboBox(gui.getFromCurrencies(), fetched);
        this.populateComboBox(gui.getToCurrencies(), fetched);
    }

    public void conversion() throws Exception {

        TextField gui_result_textfield = gui.getResultField();

        String from = gui.getFromCurrencies().getValue();
        String to = gui.getToCurrencies().getValue();
        String amountText = gui.getAmount().getText();

        if (from == null || from.isEmpty()) {
            gui.getResultField().setText("Select source currency.");
            return;
        }

        if (to == null || to.isEmpty()) {
            gui.getResultField().setText("Select target currency.");
            return;
        }

        String fromCode;
        String toCode;
        try {
            fromCode = from.split(" - ")[0].trim();
            toCode = to.split(" - ")[0].trim();
        } catch (Exception e) {
            gui_result_textfield.setText("Error reading currency codes.");
            return;
        }

        if (amountText == null || amountText.isEmpty()) {
            gui.getResultField().setText("Please enter an amount.");
            return;
        }

        BigDecimal amount;

        try {
            amount = new BigDecimal(gui.getAmount().getText());
        } catch (NumberFormatException e) {
            gui.getResultField().setText("Enter a valid amount.");
            return;
        }

        BigDecimal retrieve_conversion;

        try {
            retrieve_conversion = model.convert(fromCode, toCode, amount);
        } catch(Exception e) {
            gui_result_textfield.setText("Conversion failed: " + e.getMessage());
            return;
        }

        String symbol;
        try {
            Currency currency_instance = Currency.getInstance(toCode);
            symbol = currency_instance.getSymbol(Locale.getDefault());
            if (symbol == null || symbol.isEmpty() || symbol.equals(toCode)) {
                symbol = toCode + " (no symbol)";
            }
        } catch (Exception e) {
            // If the currency code is invalid or not ISO 4217
            symbol = toCode + " (no symbol)";
        }

        gui_result_textfield.setText(retrieve_conversion.toString() + " " + symbol);


        /*
           char[] from_char_array = from.toCharArray(); // splitting the "from" into char array
           char[] to_char_array = to.toCharArray(); // splitting the "to" into char array

           StringBuilder derived_from = new StringBuilder();
           StringBuilder derived_to = new StringBuilder();

           for (int i = 0; i < 4; i++) {
               derived_from.append(from_char_array[i]);
               derived_to.append(to_char_array[i]);
           }
        */
    }

}
