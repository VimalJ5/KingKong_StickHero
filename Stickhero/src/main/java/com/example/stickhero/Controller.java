package com.example.stickhero;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Rectangle tower1;
    @FXML
    private Circle hero;

    @FXML
    private ImageView monke;

    @FXML
    private Rectangle tower3;



    public void startPosition() {
        tower1.setLayoutX(379);
        tower1.setLayoutY(405);
    }


    public void testing(ActionEvent event) {
        System.out.println("Working");
    }

    public void gameSceneShift(ActionEvent event) throws IOException {
        Stage stage;
        Scene gameScene;

        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("GameScene.fxml"));
        Parent root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        gameScene = new Scene(root);
        stage.setScene(gameScene);
        stage.show();

    }

    private void setPositions() {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        startPosition();
    }
}