package view;
import controller.Controller;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.EventHandler;
import java.util.ArrayList;
import java.util.Arrays;


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

    private EventHandler<ActionEvent> convert_event;

    public TextField getAmount() {return amount;}
    public ComboBox<String> getFromCurrencies() {return from_currencies;}
    public ComboBox<String> getToCurrencies() {return to_currencies;}
    public Button getConvertButton() {return convert;}
    public TextField getResultField() {return result;}


    VBox root = new VBox();
    VBox amount_section = new VBox();
    VBox from_currency_section = new VBox();
    VBox to_currency_section = new VBox();
    VBox results_section = new VBox();
    VBox result_field = new VBox();
    ArrayList<Label> labels = new ArrayList<>();


    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Currency Converter");

        Controller exchange_rate_controller = new Controller(this);
        exchange_rate_controller.initialize();
        // note we initialize to: getFromCurrencies() and getToCurrencies()

        amount.setPromptText("Enter amount");

        result.setEditable(false);
        result.setPromptText("Result displayed here");

        amount_section.getChildren().addAll(amount_label, amount);
        from_currency_section.getChildren().addAll(from_currency_label, from_currencies);
        to_currency_section.getChildren().addAll(to_currency_label, to_currencies);
        result_field.getChildren().addAll(result_label, result);
        results_section.getChildren().addAll(convert, result_field);

        root.getChildren().addAll(
                amount_section,
                from_currency_section,
                to_currency_section,
                results_section
        );

        labels.addAll(Arrays.asList(
                amount_label,
                from_currency_label,
                to_currency_label,
                result_label)
        );


        root.setPadding(new Insets(10));
        root.setAlignment(Pos.TOP_CENTER);
        root.setFillWidth(true);

        amount_section.setPadding(new Insets(5));
        amount_section.setAlignment(Pos.CENTER);
        amount_section.setFillWidth(false);

        from_currency_section.setPadding(new Insets(5));
        from_currency_section.setAlignment(Pos.CENTER);

        to_currency_section.setPadding(new Insets(5));
        to_currency_section.setAlignment(Pos.CENTER);

        results_section.setPadding(new Insets(20, 0, 5, 0));
        results_section.setAlignment(Pos.CENTER);
        results_section.setFillWidth(false);
        result_field.setPadding(new Insets(30, 0, 0, 0));
        result_field.setAlignment(Pos.CENTER);
        result_label.setAlignment(Pos.CENTER);

        /*
                for (Label i : labels) {
            i.setPadding()
        }
         */

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/CSS/stylesheet.css");
        stage.setScene(scene);
        stage.show();


        convert_event = actionEvent -> {
            try {
                exchange_rate_controller.conversion();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };

        convert.setOnAction(convert_event);


    }
}
