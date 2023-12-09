package com.example.stickhero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class EndgameController {

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private Stage stage;
    private Scene gameScene;
    private Parent root;

    private Monkey monke;

    @FXML
    private Rectangle tower1;
    @FXML
    private Rectangle tower2;

    public void menuSceneShift(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("Homepage.fxml"));
        Parent root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        gameScene = new Scene(root);
        stage.setScene(gameScene);
        stage.show();
    }

    public void gameSceneShift(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("GameScene.fxml"));
        Parent root = loader.load();

        PlayingController playingController = loader.getController();
        playingController.setStage(stage);

        Scene gameScene = new Scene(root);
        stage.setScene(gameScene);
        stage.setResizable(true);
        stage.show();
    }




    public void Revive(ActionEvent event) throws IOException{
        System.out.println("This is for the revive button");
    }
}
