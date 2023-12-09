package com.example.stickhero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EndgameController implements Initializable {

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private Monkey monkey;

    private Stage stage;
    private Scene gameScene;
    private Parent root;


    @FXML
    private Rectangle tower1;
    @FXML
    private Rectangle tower2;

    @FXML
    private ImageView monkeyImageView;
    private MediaPlayer endmediaPlayer;
    private MediaPlayer gamemediaPlayer;
    private MediaPlayer startmediaPlayer;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File mediafile=new File("src/main/resources/com/example/stickhero/end.mp3");
        Media start=new Media(mediafile.toURI().toString());
        endmediaPlayer=new MediaPlayer(start);
        endmediaPlayer.play();
    }

    public void revive(MouseEvent event) throws IOException {

    }


    public void menuSceneShift(MouseEvent event) throws IOException {
        endmediaPlayer.stop();


        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("Homepage.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        gameScene = new Scene(root);
        stage.setScene(gameScene);
        stage.show();
    }

    public void gameSceneShift(MouseEvent event) throws IOException {
        endmediaPlayer.stop();


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

    public void Revive(ActionEvent event) throws IOException {
        endmediaPlayer.stop();
        System.out.println("This is for the revive button");
    }
}