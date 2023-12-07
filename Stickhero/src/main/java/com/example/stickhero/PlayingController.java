package com.example.stickhero;

import javafx.animation.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class PlayingController implements Initializable {

    private final int tower_height = 350;

    private Stage stage;
    private Scene gameScene;
    private Parent root;

    @FXML
    private AnchorPane gamePane;

    @FXML
    private ImageView monkeyImageView;

    @FXML
    private Rectangle tower1;
    @FXML
    private Rectangle stick;

    @FXML
    private Rectangle endPosition;

    @FXML
    private Rectangle tower2;
    @FXML
    private ImageView bananaImageView;

    private Monkey monkeyCharacter;
    private Towers towersClass;
    private Banana banana;
    private Stick stickClass;

    private Timeline init_pos;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeGame();
    }

    private void initializeGame() {

        towersClass = new Towers();
        monkeyCharacter = new Monkey(monkeyImageView, banana, towersClass,tower1,tower2);
        banana = new Banana(bananaImageView);
        initialSetups();

        Thread gameThread = new Thread(() -> {
            try {
                Thread.sleep(2550);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            Platform.runLater(() -> {
                startGame();
            });
        });
        gameThread.start();
    }

    private void startGame(){
        init_stickPlacement();
        //monkeyCharacter.monkeyWalking(monkeyCharacter, stickClass, towersClass);
        towersClass.initTimeline(monkeyCharacter,stickClass, towersClass, banana);
    }

    private void initialSetups() {
        bananaImageView.setVisible(false);
        tower1.setHeight(tower_height);
        tower1.setLayoutX(0);
        tower1.setLayoutY(0);
        tower1.setX(610);
        tower1.setY(470);
        //tower1.setY(gamePane.getPrefHeight() - tower_height);
        tower1.setWidth(100);

        monkeyCharacter.setPosition(629, 422);
        //monkeyCharacter.setPosition(629, gamePane.getPrefHeight() - tower_height - 50);
        stick.setVisible(false);

        init_moveMonkeyAndTower();
    }

    private void init_stickPlacement() {
        Rectangle stickRectangle = new Rectangle();

        stickRectangle.setWidth(5);
        stickRectangle.setHeight(5);
        stickRectangle.setFill(Color.SADDLEBROWN);
        stickRectangle.setStrokeWidth(1);
        stickRectangle.setStroke(Color.DARKKHAKI);

        double stickX = tower1.getWidth() + tower1.getX() - stickRectangle.getWidth();
        double stickY = tower1.getY() - stickRectangle.getHeight();

        stickRectangle.setX(stickX);
        stickRectangle.setY(stickY);

        gamePane.getChildren().add(stickRectangle);
        stickClass = new Stick(stickRectangle);
    }

    private void init_moveMonkeyAndTower() {
        init_pos = new Timeline(new KeyFrame(Duration.seconds(0.005), event -> {
            if (monkeyCharacter.getMonkeyImageView().getX() > 30.0) {
                monkeyCharacter.getMonkeyImageView().setX(monkeyCharacter.getMonkeyImageView().getX() - 2);
                tower1.setX(tower1.getX() - 2);
            } else {
                stop_init_pos();
            }
        }));
        init_pos.setCycleCount(Timeline.INDEFINITE);
        init_pos.play();
    }

    private void stop_init_pos() {
        init_pos.stop();
    }


    public void endSceneShift(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("End.fxml"));
        Parent root = loader.load();

        Scene gameScene = new Scene(root);
        stage.setScene(gameScene);
        stage.setResizable(false);
        stage.show();
    }
}