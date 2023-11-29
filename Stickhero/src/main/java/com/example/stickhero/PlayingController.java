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
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
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

    @FXML
    private Rectangle tower2;

    private Monkey monkeyCharacter;
    private Towers towersClass;
    private Banana banana;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeGame();
    }

    private void initializeGame() {
        towersClass = new Towers();
        monkeyCharacter = new Monkey(monkeyImageView, banana, towersClass);
        banana = new Banana();
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
//        tower1.setLayoutX(100);
        System.out.println("After layout changes:");
        System.out.println(tower1.getX());
        System.out.println(tower1.getLayoutX());

        System.out.println("Game is starting bow bow bow");

    }

    private void initialSetups() {
//        tower1.setLayoutX(610);
//        tower1.setLayoutY(372);
        tower1.setX(610);
        tower1.setY(372);
        tower1.setWidth(100);

        monkeyCharacter.setPosition(629, 324);
        stick.setVisible(false);

        init_moveMonkeyAndTower();
    }

    private void stickPlacement() {
        Rectangle stickRectangle = new Rectangle();

        stickRectangle.setWidth(5);
        stickRectangle.setHeight(5);
        stickRectangle.setFill(Color.SANDYBROWN);

        double stickX = tower1.getWidth() + tower1.getX();
        double stickY = tower1.getLayoutY() - stickRectangle.getHeight();

        stickRectangle.setLayoutX(stickX);
        stickRectangle.setLayoutY(stickY);

        gamePane.getChildren().add(stickRectangle);
    }

//    private void init_moveMonkeyAndTower() {
//
//    }



    private void init_moveMonkeyAndTower() {
        ParallelTransition moveTransition = new ParallelTransition();

        double monkeyTranslateX = 23 - 629;
        double monkeyTranslateY = 0 ;
        double towerTranslateX = -510;
        double towerTranslateY = 0;

        TranslateTransition monkeyTransition = new TranslateTransition(Duration.seconds(1), monkeyImageView);
        monkeyTransition.setToX(monkeyTranslateX);
        monkeyTransition.setToY(monkeyTranslateY);

        TranslateTransition towerTransition = new TranslateTransition(Duration.seconds(1), tower1);
        //towerTransition.setFromX(tower1.getLayoutX());
        towerTransition.setToX(towerTranslateX);
        towerTransition.setToY(towerTranslateY);

        moveTransition.getChildren().addAll(monkeyTransition, towerTransition);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), endPosition);
        fadeTransition.setToValue(1.0);

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(.75), e -> {
            moveTransition.play();

            fadeTransition.play();

            fadeTransition.setOnFinished(event -> {
                createNewRectangle();
            });
        }),
                new KeyFrame(Duration.seconds(1.75), e -> stickPlacement())
        );
        timeline.play();
    }


    private void createNewRectangle() {
        Random rand = new Random();
        double randomX = 95 + rand.nextDouble() * (720);
        double randomWidth = 80 + rand.nextDouble() * (165);

        tower2 = towersClass.createTower(350, randomWidth, randomX, 370);

        gamePane.getChildren().add(tower2);
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