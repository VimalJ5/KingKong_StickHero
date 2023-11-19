package com.example.stickhero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class PlayingController implements Initializable {

    private Stage stage;
    private Scene gameScene;
    private Parent root;

    @FXML
    private Rectangle tower1;
    @FXML
    private Rectangle tower2;
    @FXML
    private Rectangle tower3;

//    @FXML
//    private Towers tower1;
//    @FXML
//    private Towers tower2;
//    @FXML
//    private Towers tower3;

    private Monkey monke = new Monkey();
    @FXML
    private Circle circle;

    public void menuSceneShift(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("Homepage.fxml"));
        Parent root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        gameScene = new Scene(root);
        stage.setScene(gameScene);
        stage.show();
    }



    private void towerSetups()
    {
        tower1.setVisible(true);
        tower2.setVisible(true);
        tower3.setVisible(false);

        Random rand = new Random();
        double randomX = 200 + rand.nextDouble() * (700 - 200);
        double randomWidth = 50 + rand.nextDouble() * (250 - 50);

        tower1.setX(40);
        tower2.setLayoutX(randomX);
        //tower2.setLayoutY(404);
        tower2.setWidth(randomWidth);


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Hello World");
        towerSetups();
    }
}