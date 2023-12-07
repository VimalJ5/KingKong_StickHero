package com.example.stickhero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private Stage stage;
    private Scene gameScene;
    private Parent root;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private Rectangle tower1;

    @FXML
    private Button playButton;

    public void startPosition() {
        tower1.setLayoutX(610);
        tower1.setLayoutY(372);
    }

    public void testing(ActionEvent event) {
        System.out.println("Working");
    }

    public void gameSceneShift(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("GameScene.fxml"));
        //FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("GameScene - Copy.fxml"));
        Parent root = loader.load();

        PlayingController playingController = loader.getController();

        Scene gameScene = new Scene(root);
        stage.setScene(gameScene);
        stage.setResizable(true);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        startPosition();
    }
}

