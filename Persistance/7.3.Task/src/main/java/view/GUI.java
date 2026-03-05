package view;

import controller.Controller;
import entity.Currency;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUI extends Application {

    private Label amount_label = new Label("Amount");
    private TextField amount = new TextField();

    private Label from_currency_label = new Label("Convert From");
    private ComboBox<String> from_currencies = new ComboBox<>();
    private Label to_currency_label = new Label("Convert To");
    private ComboBox<String> to_currencies = new ComboBox<>();

    private Button convert = new Button("Convert");
    private Label result_label = new Label("Result");
    private TextField result = new TextField();
    private Button addCurrency = new Button("Add Currency");


    private Controller controller;

    public TextField getAmount() { return amount; }
    public ComboBox<String> getFromCurrencies() { return from_currencies; }
    public ComboBox<String> getToCurrencies() { return to_currencies; }
    public Button getConvertButton() { return convert; }
    public TextField getResultField() { return result; }

    private void openAddCurrencyWindow() {

        Stage newStage = new Stage();
        newStage.setTitle("Add Currency");

        TextField codeField = new TextField();
        TextField nameField = new TextField();
        TextField rateField = new TextField();
        Button saveButton = new Button("Save");

        VBox layout = new VBox(
                new Label("Code"), codeField,
                new Label("Name"), nameField,
                new Label("Rate to USD"), rateField,
                saveButton
        );

        layout.setSpacing(5);
        layout.setPadding(new Insets(10));

        saveButton.setOnAction(e -> {
            try {
                Currency currency = new Currency(
                        codeField.getText().trim().toUpperCase(),
                        nameField.getText().trim(),
                        Double.parseDouble(rateField.getText())
                );

                controller.addCurrency(currency);
                newStage.close();

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        });

        newStage.setScene(new Scene(layout, 250, 250));
        newStage.showAndWait();

        try {
            controller.populateCurrencyComboBoxes(); // BONUS POINT
        } catch (Exception ignored) {}
    }


    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Currency Converter");

        // Instantiate the controller
        controller = new Controller(this);

        controller.updateDatabaseFromAPI();

        controller.populateCurrencyComboBoxes();

        // Setup TextFields
        amount.setPromptText("Enter amount");
        result.setEditable(false);
        result.setPromptText("Result displayed here");

        // Layout sections
        VBox amountSection = new VBox(amount_label, amount);
        VBox fromSection = new VBox(from_currency_label, from_currencies);
        VBox toSection = new VBox(to_currency_label, to_currencies);
        VBox resultSection = new VBox(convert, result_label, result, addCurrency);

        amountSection.setPadding(new Insets(5));
        amountSection.setAlignment(Pos.CENTER);
        fromSection.setPadding(new Insets(5));
        fromSection.setAlignment(Pos.CENTER);
        toSection.setPadding(new Insets(5));
        toSection.setAlignment(Pos.CENTER);
        resultSection.setPadding(new Insets(20, 0, 5, 0));
        resultSection.setSpacing(5);
        resultSection.setAlignment(Pos.CENTER);

        VBox root = new VBox(amountSection, fromSection, toSection, resultSection);
        root.setPadding(new Insets(10));
        root.setSpacing(5);
        root.setAlignment(Pos.TOP_CENTER);

        // Setup convert button action
        convert.setOnAction((ActionEvent e) -> {
            try {
                controller.conversion();
            } catch (Exception ex) {
                result.setText("Error: " + ex.getMessage());
            }
        });

        addCurrency.setOnAction(e -> openAddCurrencyWindow());


        Scene scene = new Scene(root, 300, 400);
        stage.setScene(scene);
        stage.show();
    }
}
