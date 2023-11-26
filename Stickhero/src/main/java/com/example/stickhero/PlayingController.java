package com.example.stickhero;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.EventObject;
import java.util.Random;
import java.util.ResourceBundle;

public class PlayingController implements Initializable {

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

    private Monkey monkeyCharacter;
    private Towers towers;
    private Banana banana;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeGame();
    }

    private void initializeGame() {
        monkeyCharacter = new Monkey(monkeyImageView, banana, tower1);
        towers = new Towers();
        banana = new Banana();
        initialSetups();
    }

    private void initialSetups() {
        tower1.setLayoutX(610);
        tower1.setLayoutY(372);

        monkeyCharacter.setPosition(629, 324);
        stick.setVisible(false);

        init_moveMonkeyAndTower();
    }

    private void stickPlacement() {
        // Create a new stick rectangle
        Rectangle stickRectangle = new Rectangle();

        // Set its properties
        stickRectangle.setWidth(5);
        stickRectangle.setHeight(5);
        stickRectangle.setFill(javafx.scene.paint.Color.BLACK); // Set your desired color

        // Calculate the position on top of the tower
        double stickX = tower1.getLayoutX() + tower1.getWidth() / 2 - stickRectangle.getWidth() / 2;
        double stickY = tower1.getLayoutY() - stickRectangle.getHeight();

        // Set the position
        stickRectangle.setLayoutX(stickX);
        stickRectangle.setLayoutY(stickY);

        // Add the stick to the gamePane
        gamePane.getChildren().add(stickRectangle);
    }


    private void init_moveMonkeyAndTower() {
        ParallelTransition moveTransition = new ParallelTransition();
        ParallelTransition StickandTower = new ParallelTransition();

        double monkeyTranslateX = 23 - 629;
        double monkeyTranslateY = 0 ;
        double towerTranslateX = -610;
        double towerTranslateY = 0;

        TranslateTransition monkeyTransition = new TranslateTransition(Duration.seconds(1), monkeyImageView);
        monkeyTransition.setToX(monkeyTranslateX);
        monkeyTransition.setToY(monkeyTranslateY);

        TranslateTransition towerTransition = new TranslateTransition(Duration.seconds(1), tower1);
        towerTransition.setToX(towerTranslateX);
        towerTransition.setToY(towerTranslateY);

        moveTransition.getChildren().addAll(monkeyTransition, towerTransition);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), endPosition);
        fadeTransition.setToValue(1.0);

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(.75), e -> {
            moveTransition.play();

            fadeTransition.play();

            fadeTransition.setOnFinished(event -> createNewRectangle());
        }),
            new KeyFrame(Duration.seconds(1.75), e -> stickPlacement())
        );
        timeline.play();
    }

    private void createNewRectangle() {
        Random rand = new Random();
        double randomX = 95 + rand.nextDouble() * (720);
        double randomWidth = 80 + rand.nextDouble() * (165);

        Rectangle newRectangle = towers.createTower(350, randomWidth, randomX, 370);

        gamePane.getChildren().add(newRectangle);
    }

    public void endSceneShift(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("End.fxml"));
        Parent root = loader.load();

        Scene gameScene = new Scene(root);
        stage.setScene(gameScene);
        stage.show();
    }
}
