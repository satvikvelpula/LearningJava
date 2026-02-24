package view;

import controller.Controller;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Model;

import java.net.URL;

public class GUI extends Application {

    private Canvas canvas;
    private GraphicsContext gc;
    private Image sprite;
    private Controller controller;
    private Model model;
    private double centerX;
    private double centerY;


    @Override
    public void start(Stage stage) throws Exception {

        canvas = new Canvas(800, 600);
        gc = canvas.getGraphicsContext2D();

        URL resource = getClass().getResource("/images/coco.jpg");
        if (resource == null) {
            System.out.println("Resource not found!");
            return;
        }

        sprite = new Image(resource.toExternalForm(), 80, 80, true, true);

        if (sprite.isError()) {
            throw sprite.getException();
        }

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root, 800, 600);

        canvas.widthProperty().bind(scene.widthProperty());
        canvas.heightProperty().bind(scene.heightProperty());

        stage.setScene(scene);
        stage.setTitle("Virtual Pet Demo");
        stage.show();

        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                centerX = scene.getWidth() / 2;
                centerY = scene.getHeight() / 2;

                model = new Model(centerX, centerY);
                controller = new Controller(GUI.this, model);

                draw(model.getX(), model.getY());
            }
        });
    }

    /**
     * Draw sprite centered at (x, y)
     */
    public void draw(double x, double y) {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.drawImage(
                sprite,
                x - sprite.getWidth() / 2,
                y - sprite.getHeight() / 2
        );
    }

    public void setOnMouseMoved(EventHandler<? super MouseEvent> handler) {
        canvas.setOnMouseMoved(handler);
    }

    public void setOnMouseExited(EventHandler<? super MouseEvent> handler) {
        canvas.setOnMouseExited(handler);
    }

    public double getCenterX() {return centerX;}
    public double getCenterY() {return centerY;}
    }
        /*
        canvas = new Canvas(800, 600);
        gc = canvas.getGraphicsContext2D();

        URL resource = getClass().getResource("/images/coco.jpg"); // path to your sprite
        if (resource == null) {
            System.out.println("Resource not found!");
            return;
        }
        sprite = new Image(resource.toExternalForm(), 80, 80, true, true);
        if (sprite.isError()) {
            throw sprite.getException();
        }


        model = new Model(canvas.getWidth() / 2, canvas.getHeight() / 2); // default constructor

        controller = new Controller(this, model);

        draw(model.getX(), model.getY());

        canvas.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                model.setTarget(event.getX(), event.getY());
                model.update();

                // Redraw sprite at new position
                draw(model.getX(), model.getY());
            }
        });

        canvas.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {
                model.setTarget(model.getX(), model.getY());
            }
        });

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root, 800, 600);
        canvas.widthProperty().bind(scene.widthProperty());
        canvas.heightProperty().bind(scene.heightProperty());
        stage.setScene(scene);
        stage.setTitle("Virtual Pet Demo");
        stage.show();
    }

        */

    /**
     * Draws the sprite at the given x, y coordinates.
     * Clears the previous frame first.
     */
    /*
    public void draw(double x, double y) {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.drawImage(sprite, x - sprite.getWidth() / 2, y - sprite.getHeight() / 2);
    }

     */
