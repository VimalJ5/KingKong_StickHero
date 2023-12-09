//Note there is an error I've to take care of. Slight adjustment of the 2nd tower. The 2nd tower might overlap as of now.

package com.example.stickhero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource( "Homepage.fxml"));
        Parent root = loader.load();


        Scene scene = new Scene(root);
        stage.setTitle("Ninja Harambe");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}