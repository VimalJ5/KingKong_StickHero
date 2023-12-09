package com.example.stickhero;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Stick {
    private Stage stage;
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

    public void StickGrowTimeline(Monkey monkey, Stick stick, Towers towers, Banana banana,Stage stage)
    {

        double max=500;
        System.out.println("Start grow");
        stickgrowing = new Timeline(new KeyFrame(Duration.seconds(0.005), event -> {

            if(stick.getStick().getHeight()<max)
            {


                stick.getStick().setY(stick.getStick().getY()-2);
                stick.getStick().setHeight(stick.getStick().getHeight()+2);


            } else {
                stop_growth(monkey,stick,towers, banana, stage);
            }

        }));
        stickgrowing.setCycleCount(Timeline.INDEFINITE);
        stickgrowing.play();
    }

    private void stop_growth(Monkey monkey, Stick stick, Towers towers, Banana banana, Stage stage )  {
        stickgrowing.stop();
        System.out.println("Stop grow");
        stickFalling(monkey,stick,towers, banana);
        monkey.monkeypunching(monkey, stick, towers, banana, stage);

    }

    public void stickFalling(Monkey monkey, Stick stick, Towers towers, Banana banana)
    {
        System.out.println("Start fall");
        Rotate rotate=new Rotate();
        rotate.setAngle(1);
        rotate.setPivotX(stick.getStick().getX());
        rotate.setPivotY(465);
        final double[] angle = {0};

        stickfalling = new Timeline(new KeyFrame(Duration.seconds(0.02), event -> {

            if(angle[0] <90)
            {
                stick.getStick().getTransforms().add(rotate);
                angle[0]++;
            } else {
                stop_fall(monkey,stick,towers, banana);
            }

        }));
        stickfalling.setCycleCount(Timeline.INDEFINITE);
        stickfalling.play();
    }

    private void stop_fall(Monkey monkey, Stick stick, Towers towers, Banana banana) {
        System.out.println("Stop fall");
        stickfalling.stop();

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
