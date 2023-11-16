package com.example.stickhero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("Homepage.fxml"));
        Parent root = loader.load();

        Controller controller = new Controller();
        loader.setController(controller);

        Scene scene = new Scene(root);
        stage.setTitle("StickHero");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}