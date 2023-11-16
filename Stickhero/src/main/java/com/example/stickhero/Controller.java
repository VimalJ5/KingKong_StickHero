package com.example.stickhero;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class Controller {
    @FXML
    private Rectangle tower1;
    @FXML
    private Rectangle tower2;

    @FXML
    private Circle hero;

    private int x1;
    private int x2;

    private Stage stage;
    private Scene gameScene;
    private Parent root;

    public void startPosition() {
        tower1.setX(40);
        tower1.setY(105);

        Random rand = new Random();
        double randomX = 200 + rand.nextDouble() * (700 - 200);
        tower2.setX(randomX);
        tower2.setY(105);
    }


    public void gamePosition() {
        gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().toString().equals("UP")) {
                    moveTower2Right();
                }
            }
        });
    }

    private void moveTower2Right() {
        double currentX = tower2.getX();
        double newX = currentX + 50;
        if (newX <= 700) {
            tower2.setX(newX);
        }
    }

    public void testing(ActionEvent event) {
        System.out.println("Working");
    }

    public void startGame() {
        gamePosition();
    }

    public void themeSceneShift() {}
    public void gameSceneShift(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("GameScene.fxml"));
        Parent root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        gameScene = new Scene(root);
        stage.setScene(gameScene);
        setTowerPositions();
        stage.show();


    }



    private void setTowerPositions() {
        tower1.setX(40);
        tower1.setY(105);

        Random rand = new Random();
        double randomX = 200 + rand.nextDouble() * (700 - 200);
        double randomWidth = 50 + rand.nextDouble() * (250 - 50);

        tower2.setX(randomX);
        tower2.setY(105);
        tower2.setWidth(randomWidth);

        hero.setCenterX(tower1.getX() + tower1.getWidth() / 2);
        hero.setCenterY(tower1.getY() - hero.getRadius());
    }



    public void menuSceneShift(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("Homepage.fxml"));
        Parent root = loader.load();

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        gameScene = new Scene(root);
        stage.setScene(gameScene);
        stage.show();

    }
    public void stickRising() {}

    public void tower_position_setter() {

    }

}