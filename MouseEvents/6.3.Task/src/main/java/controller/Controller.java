package controller;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.Model;
import view.GUI;

public class Controller {

    private Model model;
    private GUI gui;

    public Controller(GUI gui, Model model) {
        this.gui = gui;
        this.model = model;
        initialize();
    }

    private void initialize() {
        setupMouseHandling();
        startGameLoop();
    }

    public void setupMouseHandling() {
        gui.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                double mouseX = mouseEvent.getX();
                double mouseY = mouseEvent.getY();

                model.setTarget(mouseX, mouseY);
            }
        });

        gui.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {
                model.setTarget(gui.getCenterX(), gui.getCenterY());
            }
        });
    }

    public void startGameLoop() {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                model.update();

                gui.draw(model.getX(), model.getY());
            }
        };

        timer.start();
    }
}
