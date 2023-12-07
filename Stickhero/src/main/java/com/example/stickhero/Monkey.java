package com.example.stickhero;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class Monkey {
    private boolean isUpside;
    private Banana banana;
    private ImageView monkeyImageView;
    private Towers tower;
    private Timeline monkeywalk;
    private Timeline monkeypunch;
    private double frame_changer;
    private List<Image> walkingFrame;
    private List<Image> punchingFrame;

    private Rectangle currentTower;

    private Rectangle nextTower;

    private final int width = 50;
    private final int height = 50;
    private int count;

    public Monkey(ImageView monkeyImageView, Banana banana, Towers tower, Rectangle currentTower, Rectangle nextTower) {
        this.isUpside = false;
        this.monkeyImageView = monkeyImageView;
        this.banana = banana;
        this.tower = tower;
        this.frame_changer = 0.0;
        this.walkingFrame = new ArrayList<>();
        this.punchingFrame = new ArrayList<>();
        this.currentTower = currentTower;
        this.nextTower = nextTower;
        this.count = 0;

        for (int i = 1; i <= 8; i++) {
            String imagePath = "monke" + i + ".png";
            Image frame = new Image(getClass().getResourceAsStream(imagePath));
            walkingFrame.add(frame);
        }

        for (int i = 1; i <= 6; i++) {
            String imagePath = "Punch" + i + ".png";
            Image frame = new Image(getClass().getResourceAsStream(imagePath));
            punchingFrame.add(frame);
        }
    }

    public void setPosition(double x, double y) {
        monkeyImageView.setX(x);
        monkeyImageView.setY(y);
    }

    public void monkeypunching(Monkey monkey, Stick stick, Towers towers, Banana banana)
    {
        monkeypunch = new Timeline(new KeyFrame(Duration.seconds(0.08), event -> {
            if(count < 6){
                this.monkeyImageView.setImage(punchingFrame.get(count));
                count ++;
            }
            else {
                this.monkeyImageView.setImage(walkingFrame.get(0));
                stopping_punch(monkey,stick,towers, banana);

            }
        }));

        monkeypunch.setCycleCount(Timeline.INDEFINITE);
        monkeypunch.play();
    }

    private void stopping_punch(Monkey monkey,Stick stick, Towers towers, Banana banana)
    {
        monkeypunch.stop();
        banana.spawn_bananas(monkey,stick,towers);
        count = 0;
        monkey.monkeyWalking(monkey, stick,towers, banana);
    }

    public void monkeyWalking(Monkey monkey,Stick stick, Towers towers, Banana banana)
    {
        monkeywalk = new Timeline(new KeyFrame(Duration.seconds(0.02), event -> {
            if(this.monkeyImageView.getX() < nextTower.getX() + nextTower.getWidth() - this.monkeyImageView.getFitWidth() - 10){
                frame_changer += 0.25 ;
                if((int)frame_changer == 8){
                    this.monkeyImageView.setImage(walkingFrame.get(7));
                } else if((int)frame_changer ==7 ) {
                    this.monkeyImageView.setImage(walkingFrame.get(6));
                } else if((int)frame_changer == 6) {
                    this.monkeyImageView.setImage(walkingFrame.get(5));
                } else if((int)frame_changer == 5) {
                    this.monkeyImageView.setImage(walkingFrame.get(4));
                } else if((int)frame_changer == 4) {
                    this.monkeyImageView.setImage(walkingFrame.get(3));
                } else if((int)frame_changer == 3) {
                    this.monkeyImageView.setImage(walkingFrame.get(2));
                } else if((int)frame_changer == 2) {
                    this.monkeyImageView.setImage(walkingFrame.get(1));
                } else {
                    this.monkeyImageView.setImage(walkingFrame.get(0));
                }
                if(frame_changer == 8)
                {
                    frame_changer = 0;
                }
                this.monkeyImageView.setX(monkeyImageView.getX()+2.5);
            }
            else {
                this.monkeyImageView.setImage(walkingFrame.get(0));
                stopping_hero(monkey,stick,towers, banana);

            }
        }));

        monkeywalk.setCycleCount(Timeline.INDEFINITE);
        monkeywalk.play();
    }

    private void stopping_hero(Monkey monkey,Stick stick, Towers towers, Banana banana) {
        monkeywalk.stop();

        frame_changer = 0;
        banana.getBananaImageView().setVisible(false);

        Rectangle temp = this.currentTower;
        this.currentTower = this.nextTower;
        this.nextTower = temp;

        tower.moveScene(monkey, stick, towers, banana);
    }

    public boolean isUpside() {
        return isUpside;
    }

    public void setUpside(boolean upside) {
        isUpside = upside;
    }

    public Banana getBanana() {
        return banana;
    }

    public void setBanana(Banana banana) {
        this.banana = banana;
    }

    public ImageView getMonkeyImageView() {
        return monkeyImageView;
    }

    public void setMonkeyImageView(ImageView monkeyImageView) {
        this.monkeyImageView = monkeyImageView;
    }

    public Towers getTower() {
        return tower;
    }

    public void setTower(Towers tower) {
        this.tower = tower;
    }

    public Rectangle getCurrentTower() {
        return currentTower;
    }

    public void setCurrentTower(Rectangle currentTower) {
        this.currentTower = currentTower;
    }

    public Rectangle getNextTower() {
        return nextTower;
    }

    public void setNextTower(Rectangle nextTower) {
        this.nextTower = nextTower;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}