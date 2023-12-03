package com.example.stickhero;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Stick {
    private double height;
    private double width;
    private Rectangle stick;
    private double X;
    private double Y;

    private Timeline stickgrowing;

    public Stick(Rectangle stick)
    {
        this.stick = stick;
    }

    public void StickGrowTimeline(Monkey monkey, Stick stick, Towers towers )
    {
        final boolean[] check = {true};
        stickgrowing = new Timeline(new KeyFrame(Duration.seconds(0.005), event -> {

            if(check[0])
            {
                System.out.println("My peee pee goes boing boing");
                check[0] = false;
            } else {
                stop_growth(monkey,stick,towers);
            }

        }));
        stickgrowing.setCycleCount(Timeline.INDEFINITE);
        stickgrowing.play();
    }

    public void stop_growth(Monkey monkey, Stick stick, Towers towers )
    {
        stickgrowing.stop();
        monkey.monkeyWalking(monkey, stick, towers);
    }


    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public Rectangle getStick() {
        return stick;
    }

    public void setStick(Rectangle stick) {
        this.stick = stick;
    }

    public double getX() {
        return X;
    }

    public void setX(double x) {
        X = x;
    }

    public double getY() {
        return Y;
    }

    public void setY(double y) {
        Y = y;
    }
}
