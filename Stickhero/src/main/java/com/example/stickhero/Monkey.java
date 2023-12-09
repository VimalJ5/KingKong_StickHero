package com.example.stickhero;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Monkey {
    private boolean isUpside=true;
    private Banana banana;
    private ImageView monkeyImageView;
    private Towers tower;
    private static int Best_Score;
    private int score=0;

    private Timeline monkeywalk;
    private Timeline monkeypunch;
    private double frame_changer;
    private List<Image> walkingFrame;
    private List<Image> punchingFrame;
    private int offset=0;
    private Rectangle currentTower;

    private Rectangle nextTower;

    private final int width = 50;
    private final int height = 50;
    private int count;
    private Stage stage;

    public Monkey(Stage stage,ImageView monkeyImageView, Banana banana, Towers tower, Rectangle currentTower, Rectangle nextTower) {
        this.isUpside = true;
        this.stage=stage;
        this.monkeyImageView = monkeyImageView;
        this.banana = banana;
        this.tower = tower;
        this.frame_changer = 0.0;
        this.walkingFrame = new ArrayList<>();
        this.punchingFrame = new ArrayList<>();
        this.currentTower = currentTower;
        this.nextTower = nextTower;
        this.count = 0;

        for (int i = 1; i <= 16; i++) {
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
        stick.stickFalling(monkey,stick,towers,banana);

    }

    public void monkeyWalking(Monkey monkey,Stick stick, Towers towers, Banana banana)
    {
        AtomicBoolean upside_fall = new AtomicBoolean(false);
        AtomicBoolean fall = new AtomicBoolean(false);
        AtomicBoolean banana_cond = new AtomicBoolean(false);
        double distance=0;
        if(stick.getStick().getHeight()>((nextTower.getX()+nextTower.getWidth())-(currentTower.getX()+currentTower.getWidth()))){
            distance=stick.getStick().getHeight();
            fall.set(true);
            System.out.println("too much");
        }
        else if(stick.getStick().getHeight()<(nextTower.getX()-(currentTower.getX()+currentTower.getWidth()))){
            distance=stick.getStick().getHeight();
            fall.set(true);
            System.out.println("too little");
        }
        else{
            fall.set(false);
            distance=nextTower.getX() + nextTower.getWidth() - this.monkeyImageView.getFitWidth() - 10;
            System.out.println("nice");
        }
        double finalDistance = distance;

        Timeline upsidedowntimeline=new Timeline(new KeyFrame(Duration.seconds(2),eventupside->{
            stage.getScene().addEventFilter(KeyEvent.KEY_PRESSED,eventupsidedown->{
                if(eventupsidedown.getCode().equals(KeyCode.DOWN)){
                    if((monkeyImageView.getX()>(monkey.getCurrentTower().getWidth()))&& (monkeyImageView.getX()<(monkey.getNextTower().getX()-monkeyImageView.getFitWidth()))) {
                        monkey.turn();
                    }
                }
            });
        }));

        upsidedowntimeline.setCycleCount(Timeline.INDEFINITE);
        upsidedowntimeline.play();

        monkeywalk = new Timeline(new KeyFrame(Duration.seconds(0.02), event -> {
            if(monkey.isUpside==false){
                if(monkeyImageView.getX()>(monkey.getNextTower().getX()-monkeyImageView.getFitWidth())){
                    upside_fall.set(true);
                }
            }
            if((monkeyImageView.getX()+monkeyImageView.getFitWidth()>=banana.getBananaImageView().getX()&&(monkeyImageView.getX()<=(banana.getBananaImageView().getX()+banana.getBananaImageView().getFitWidth())))){
                banana_cond.set(true);
            }

            if(this.monkeyImageView.getX()< finalDistance && upside_fall.get()==false){
                frame_changer += .25 ;
                if((int)frame_changer == 8){
                    this.monkeyImageView.setImage(walkingFrame.get(offset+7));

                } else if((int)frame_changer ==7 ) {
                    this.monkeyImageView.setImage(walkingFrame.get(offset+6));

                } else if((int)frame_changer== 6) {
                    this.monkeyImageView.setImage(walkingFrame.get(offset+5));

                } else if((int)frame_changer== 5) {
                    this.monkeyImageView.setImage(walkingFrame.get(offset+4));

                } else if((int)frame_changer== 4) {
                    this.monkeyImageView.setImage(walkingFrame.get(offset+3));

                } else if((int)frame_changer== 3) {
                    this.monkeyImageView.setImage(walkingFrame.get(offset+2));

                } else if((int)frame_changer== 2) {
                    this.monkeyImageView.setImage(walkingFrame.get(offset+1));

                } else {
                    this.monkeyImageView.setImage(walkingFrame.get(offset+0));

                }
                if(frame_changer == 8)
                {
                    frame_changer = 0;
                }
                this.monkeyImageView.setX(monkeyImageView.getX()+2.5);

            }
            else {
                if (fall.get()==false && upside_fall.get()==false){
                    if(banana_cond.get()==true){
                        banana.increasebanana(1);
                    }
                    score++;
                }
                if(fall.get() || upside_fall.get()){
                    FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("End.fxml"));
                    Parent root = null;
                    try {
                        root = loader.load();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    Scene gameScene = new Scene(root);
                    stage.setScene(gameScene);
                    stage.setResizable(false);
                    stage.show();

                }
                upsidedowntimeline.stop();
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
    public void turn(){
        if(offset==0){
            offset=8;
            monkeyImageView.setY(monkeyImageView.getY()+50);
            isUpside=false;
        }
        else{
            offset=0;
            monkeyImageView.setY(monkeyImageView.getY()-50);
            isUpside=true;
        }
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