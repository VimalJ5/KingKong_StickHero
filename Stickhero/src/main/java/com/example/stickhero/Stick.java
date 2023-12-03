package com.example.stickhero;

import javafx.scene.shape.Rectangle;

public class Stick {
    private double height;
    private double width;
    private Rectangle stick;
    private double X;
    private double Y;

    public Stick(Rectangle stick)
    {
        this.stick = stick;
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
