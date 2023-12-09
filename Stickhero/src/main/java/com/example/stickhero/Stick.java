package com.example.stickhero;
import javafx.scene.input.KeyCode;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.concurrent.atomic.AtomicBoolean;

public class Stick {
    private Stage stage;
    private AnchorPane gamepane;
    private double height;
    private double width;
    private Rectangle stick;
    private double X;
    private double Y;
    private Timeline stickgrowing;
    private Timeline stickfalling;

    public Stick(Rectangle stick, AnchorPane gamepane, Stage stage)
    {
        this.gamepane=gamepane;
        this.stick = stick;
        this.stage = stage;

    }

    public void StickGrowTimeline(Monkey monkey, Stick stick, Towers towers, Banana banana)
    {
        AtomicBoolean cond = new AtomicBoolean(true);
        System.out.println("Start grow");
        stickgrowing = new Timeline(new KeyFrame(Duration.seconds(0.015), event -> {
            if(cond.get())
            {
                stage.getScene().addEventFilter(KeyEvent.KEY_PRESSED, eventpress -> {
                    if(eventpress.getCode().equals(KeyCode.UP)) {
                        stick.getStick().setY((stick.getStick().getY() - 0.1));
                        stick.getStick().setHeight(stick.getStick().getHeight() + 0.1);
                    }
                });
                stage.getScene().addEventFilter(KeyEvent.KEY_RELEASED,eventrelease->{
                    cond.set(false);
                });
            } else {
                stop_growth(monkey, stick, towers, banana);
            }
        }));

        stickgrowing.setCycleCount(Timeline.INDEFINITE);
        stickgrowing.play();
    }

    private void stop_growth(Monkey monkey, Stick stick, Towers towers, Banana banana)  {
        stickgrowing.stop();
        System.out.println("Stop grow");
        monkey.monkeypunching(monkey, stick, towers, banana);
    }

    public void stickFalling(Monkey monkey, Stick stick, Towers towers, Banana banana)
    {
        System.out.println("Start fall");
        Rotate rotate=new Rotate();
        rotate.setAngle(1);
        rotate.setPivotX(stick.getStick().getX());
        rotate.setPivotY(465);
        final double[] angle = {0};

        stickfalling = new Timeline(new KeyFrame(Duration.seconds(0.009), event -> {

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
        monkey.monkeyWalking(monkey, stick,towers, banana);

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
