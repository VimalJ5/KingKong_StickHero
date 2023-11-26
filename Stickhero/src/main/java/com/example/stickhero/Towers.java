package com.example.stickhero;

import javafx.scene.shape.Rectangle;

public class Towers {
    public Rectangle createTower(double height, double width, double x, double y) {
        Rectangle tower = new Rectangle();
        tower.setWidth(width);
        tower.setHeight(height);
        tower.setX(x);
        tower.setY(y);
        return tower;
    }
}
