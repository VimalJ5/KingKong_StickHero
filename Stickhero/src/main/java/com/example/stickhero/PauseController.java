package com.example.stickhero;

public class PauseController {
//
//    public void stickAnimation() {
//
//        AnimationTimer animationTimer = new AnimationTimer() {
//            public void stop()
//            {
//                setA_pressed(false);
//                setStickGrowing(false);
//                super.stop();
//            }
//
//            @Override
//            public void handle(long now) {
//
//                if (isA_pressed() && isStickGrowing() && !isRotating)
//                {
//                    bonus_blocks();
//                    Audio.stick_growing.play();
//                    stick.update();
//                }
//                else if (isRotating){
//                    Audio.stick_growing.stop();
//                    Audio.cherry_audio.stop();
//                    moving_block=false;
//                    //Starts rotation
//                    if(angle<=90.0 ){
//                        double pivotX = stick.getShape().getX() + stick.getShape().getWidth() / 2;
//                        double pivotY = (stick.getShape().getY()+stick.getShape().getHeight());
//                        stick.getShape().getTransforms().clear();
//                        Rotate r =new Rotate(angle,pivotX,pivotY);
//                        stick.getShape().getTransforms().add(r);
//                        angle= angle+1.5;
//
//                    }
//                    else{
//                        System.out.println(stick.getShape().getY());
//                        isRotating=false;
//                        animation_over=true;
//                        this.stop();
//
//                    }
//                }
//                else if (moving_block ){
//                    bonus_blocks();
//                }
//                else if (!isA_pressed())
//                {
//                    moving_block=true;
//                    this.stop();
//                }
//            }
//        };
//        timeline = new Timeline(new KeyFrame(Duration.seconds(0.05), e-> {
//
//            animationTimer.start();
//
//            if (animation_over){
//                animation_over=false;
//                stop_timeline();
//                if(stick.getHeight()+start.getLayoutX()+start.getWidth() >= second_block.getX()&& stick.getHeight()+start.getLayoutX()+start.getWidth() <= second_block.getX()+ second_block.getWidth()) {
//                    h.move_hero(this.pane, start, second_block, stick, start_pos,second_block.getX()+second_block.getWidth()- hero.getFitWidth()-15,cherries.cherry);
//                    h.moving_hero();
//                    System.out.println(timeline_stopped);
//
//
//                }
//                else{
//                    h.move_hero(this.pane, start, second_block, stick, start_pos,stick.getHeight()+start.getLayoutX()+start.getWidth()-hero.getFitWidth(),cherries.cherry);
//                    h.moving_hero();
//                    System.out.println(timeline_stopped);
//
//                }
//            }
//        }));
//        timeline.setCycleCount(Timeline.INDEFINITE);
//    }
}



//    public void stickAnimation(Monkey monkey, Stick stick, Towers towers, Banana banana)
//    {
//        AtomicBoolean isRotating = new AtomicBoolean(false);
//        AnimationTimer animationTimer = new AnimationTimer() {
//            @Override
//            public void handle(long l) {
//                if(!isRotating.get())
//                {
//                    stage.getScene().addEventFilter(KeyEvent.KEY_PRESSED, keyEvent -> {
//                        stickgrow(keyEvent);
//                    });
//                    stage.getScene().addEventFilter(KeyEvent.KEY_RELEASED, keyEvent -> {
//                        isRotating.set(true);
//                    });
//                } else {
//                    Rotate rotate=new Rotate();
//                    rotate.setAngle(1);
//                    rotate.setPivotX(stick.getStick().getX());
//                    rotate.setPivotY(465);
//                    final double[] angle = {0};
//
//                    if(angle[0] <90)
//                    {
//                        stick.getStick().getTransforms().add(rotate);
//                        angle[0]++;
//                    } else {
//                        stop_fall(monkey,stick,towers, banana);
//                    }
//                }
//
//            }
//        };
//        stickgrowing = new Timeline(new KeyFrame(Duration.seconds(0.05), event -> {
//
//        }));
//    }
//
//    public void stickgrow(KeyEvent keyEvent)
//    {
//        if(keyEvent.getCode().equals(KeyCode.UP)) {
//            this.stick.setY(this.stick.getY() - 0.1);
//            this.stick.setHeight(this.stick.getHeight() + 0.1);
//        }
//    }
