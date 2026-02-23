package view;
import controller.DictionaryController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.EventHandler;
import javafx.scene.layout.FlowPane;



public class DictionaryGUI extends Application {

    private Label result = new Label();
    private Label debug_result = new Label();
    private Label warning = new Label();
    private TextField user_input = new TextField();
    Button populateButton = new Button("Populate");
    VBox pane = new VBox();
    VBox results_pane = new VBox();
    HBox buttons_pane = new HBox();

    public TextField getUserInput() {
        return user_input;
    }
    public Label getResult() {
        return result;
    }
    public Button getButton() {
        return populateButton;
    }
    public Label getDebugResult() { return debug_result; }


    @Override
    public void start(Stage stage) throws Exception {

        DictionaryController controller = new DictionaryController(this);
        TextField user_input = getUserInput();
        user_input.setPromptText("Enter a word. ");
        Button searchButton = new Button("Get meaning");
        Button populateButton = getButton();
        populateButton.setText("Populate");
        Label result = getResult();
        Label debugResult = getDebugResult();
        stage.setTitle("Dictionary");


        pane.setPadding(new Insets(10));
        pane.setAlignment(Pos.TOP_CENTER);
        pane.setFillWidth(true);

        buttons_pane.setPadding(new Insets(5));
        buttons_pane.setAlignment(Pos.CENTER);
        buttons_pane.setSpacing(10);
        buttons_pane.getChildren().addAll(searchButton, populateButton);

        results_pane.setPadding(new Insets(2));
        results_pane.setAlignment(Pos. TOP_CENTER);

        results_pane.getChildren().addAll(result, debugResult);


        result.setAlignment(Pos.CENTER);
        debugResult.setAlignment(Pos.CENTER);
        result.setMaxWidth(Double.MAX_VALUE);
        debugResult.setMaxWidth(Double.MAX_VALUE);
        results_pane.setFillWidth(true);
        pane.setStyle("-fx-border-color: green;");
        results_pane.setStyle("-fx-border-color: purple;");
        result.setStyle("-fx-border-color: red;");
        debugResult.setStyle("-fx-border-color: blue;");

        pane.getChildren().addAll(
                user_input,
                buttons_pane,
                results_pane
        );

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

        // Add Populate button action event here
        EventHandler<ActionEvent> populate_event = actionEvent -> controller.populate();
        EventHandler<ActionEvent> button_event = actionEvent -> controller.search();

        populateButton.setOnAction(populate_event);
        searchButton.setOnAction(button_event);

        /*
        FlowPane.setMargin(result, labelInsets);
        FlowPane.setMargin(debugResult, labelInsets);
        FlowPane.setMargin(user_input, insets);
        FlowPane.setMargin(searchButton, insets);
        FlowPane.setMargin(populateButton, insets);
         */

        /*
         */



    }
}
