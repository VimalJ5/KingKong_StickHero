package com.example.stickhero;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Towers {
    ActionEvent event;
    private Timeline moveSceneTimeline;
    public Rectangle createTower(double height, double width, double x, double y) {
        Rectangle tower = new Rectangle();
        tower.setWidth(width);
        tower.setHeight(height);
        tower.setX(x);
        tower.setY(y);
        return tower;
    }

    public void moveScene(Rectangle first, Rectangle second, double start_pos, Monkey monkey) {

        Timeline move_scene = new Timeline(new KeyFrame(Duration.seconds(0.005), event -> {
            if (second.getX() > start_pos) {
                first.setLayoutY(first.getLayoutY() - 1);
                second.setX(second.getX() - 1);
                monkey.getMonkeyImageView().setX(monkey.getMonkeyImageView().getX() - 1);
            } else {
                stopping_scene();
            }
        }));

        moveSceneTimeline.setCycleCount(Timeline.INDEFINITE);
        moveSceneTimeline.play();
    }

    public void stopping_scene()
    {
        if (moveSceneTimeline != null) {
            moveSceneTimeline.stop();
        }
    }
}
