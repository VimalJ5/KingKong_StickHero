package com.example.stickhero;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.util.concurrent.BlockingDeque;

public class Monkey {
    private boolean isUpside;
    private Banana banana;
    private ImageView monkeyImageView;
    private Rectangle block;

    private final int width = 50;
    private final int height = 50;

    public Monkey(ImageView monkeyImageView, Banana banana, Rectangle tower) {
        this.isUpside = false;
        this.monkeyImageView = monkeyImageView;
        this.banana = banana;
        this.block = tower;
    }

    public void walkingMotion(double deltaX) {
        monkeyImageView.setLayoutX(monkeyImageView.getLayoutX() + deltaX);
    }

    public void setPosition(double x, double y) {
        monkeyImageView.setLayoutX(x);
        monkeyImageView.setLayoutY(y);
    }

    public void monkeyWalk()
    {
        
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

    public Rectangle getBlock() {
        return block;
    }

    public void setBlock(Rectangle block) {
        this.block = block;
    }
}
