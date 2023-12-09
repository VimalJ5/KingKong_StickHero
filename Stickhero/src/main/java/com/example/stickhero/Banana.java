package com.example.stickhero;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class Banana {
    private static int banana_count;
    private ImageView bananaImageView;
    private Random random;
    private int chance;

    public Banana(ImageView bananaImageView)
    {
        this.bananaImageView = bananaImageView;
        this.random = new Random();
    }

    public void spawn_bananas(Monkey monkey, Stick stick, Towers towers) {
        chance = random.nextInt(0,9);
        if(chance<4)
        {
            double iniit_value = monkey.getCurrentTower().getX() + monkey.getCurrentTower().getWidth() + 20;
            double end_val = monkey.getNextTower().getX() - bananaImageView.getFitWidth() - 20;
            double randomX = random.nextDouble(iniit_value,end_val);
            bananaImageView.setX(randomX);
            bananaImageView.setY(monkey.getCurrentTower().getY() + 10);
            bananaImageView.setVisible(true);
        } else {
            System.out.println(chance);
            System.out.println("No Bananana");
        }
    }

    public ImageView getBananaImageView() {
        return bananaImageView;
    }

    public void setBananaImageView(ImageView bananaImageView) {
        this.bananaImageView = bananaImageView;
    }

    public void increasebanana(int i)
    {
        banana_count = banana_count + i;
        System.out.println(banana_count);
    }
}
