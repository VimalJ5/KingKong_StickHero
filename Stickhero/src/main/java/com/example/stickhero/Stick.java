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
    private Timeline stickfalling;

    public Stick(Rectangle stick)
    {
        this.stick = stick;
    }

    public void StickGrowTimeline(Monkey monkey, Stick stick, Towers towers, Banana banana )
    {
        final boolean[] check = {true};
        stickgrowing = new Timeline(new KeyFrame(Duration.seconds(0.05), event -> {

            if(check[0])
            {
                System.out.println("My peee pee goes boing boing");
                check[0] = false;
            } else {
                stop_growth(monkey,stick,towers, banana);
            }

        }));
        stickgrowing.setCycleCount(Timeline.INDEFINITE);
        stickgrowing.play();
    }

    private void stop_growth(Monkey monkey, Stick stick, Towers towers, Banana banana )
    {
        stickgrowing.stop();
        stickFalling(monkey,stick,towers, banana);
    }

    public void stickFalling(Monkey monkey, Stick stick, Towers towers, Banana banana)
    {
        final boolean[] check = {true};
        stickfalling = new Timeline(new KeyFrame(Duration.seconds(0.05), event -> {

            if(check[0])
            {
                System.out.println("My peee pee goes lands on the tower");
                check[0] = false;
            } else {
                stop_fall(monkey,stick,towers, banana);
            }

        }));
        stickfalling.setCycleCount(Timeline.INDEFINITE);
        stickfalling.play();
    }

    private void stop_fall(Monkey monkey, Stick stick, Towers towers, Banana banana) {
        stickfalling.stop();
        monkey.monkeypunching(monkey, stick, towers, banana);
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
