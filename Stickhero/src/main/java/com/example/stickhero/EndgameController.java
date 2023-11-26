package com.example.stickhero;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EndgameController {

    private Stage stage;
    private Scene gameScene;
    private Parent root;

    private Monkey monke;

    public void menuSceneShift(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("Homepage.fxml"));
        Parent root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        gameScene = new Scene(root);
        stage.setScene(gameScene);
        stage.show();
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
}
