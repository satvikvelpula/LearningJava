package view;

import controller.Controller;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

    private Controller controller;

    public TextField getAmount() { return amount; }
    public ComboBox<String> getFromCurrencies() { return from_currencies; }
    public ComboBox<String> getToCurrencies() { return to_currencies; }
    public Button getConvertButton() { return convert; }
    public TextField getResultField() { return result; }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Currency Converter");

        // Instantiate the controller
        controller = new Controller(this);

        // 1️⃣ Fetch API data and update database
        controller.updateDatabaseFromAPI();

        // 2️⃣ Populate ComboBoxes from database
        controller.populateCurrencyComboBoxes();

        // Setup TextFields
        amount.setPromptText("Enter amount");
        result.setEditable(false);
        result.setPromptText("Result displayed here");

        // Layout sections
        VBox amountSection = new VBox(amount_label, amount);
        VBox fromSection = new VBox(from_currency_label, from_currencies);
        VBox toSection = new VBox(to_currency_label, to_currencies);
        VBox resultSection = new VBox(convert, result_label, result);

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

        Scene scene = new Scene(root, 300, 400);
        stage.setScene(scene);
        stage.show();
    }
}
