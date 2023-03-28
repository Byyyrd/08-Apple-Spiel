package my_project.model;

import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends InteractiveGraphicalObject {


    //Attribute
    private double speed;
    private int points;
    private double speedBuff;
    private double timer;
    private boolean buffed;

    private double debuff;
    private double debuffTimer;
    private boolean debuffed;

    private Color color;

    //Tastennummern zur Steuerung
    private int keyToGoLeft;
    private int keyToGoRight;
    private int direction;

    public Player(double x, double y, int left, int right, Color color){
        this.x = x;
        this.y = y;
        speed = 150;
        width = 80;
        height = 40;
        this.color = color;

        this.keyToGoLeft    = left;
        this.keyToGoRight   = right;
        this.direction      = -1; //-1 keine Bewegung, 0 nach rechts, 2 nach links
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(color);
        drawTool.drawFilledRectangle(x,y,width,height);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawRectangle(x,y,width,height);

       /* drawTool.drawText(10,10," Speed: " + Math.floor(speed));

        drawTool.drawText(10,30,"buff: " + Math.floor(speedBuff));
        drawTool.drawText(10,40,"timer: " + Math.floor(timer));

        drawTool.drawText(10,60,"debuff: " + Math.floor(debuff));
        drawTool.drawText(10,70,"detimer: " + Math.floor(debuffTimer));*/
    }

    @Override
    public void update(double dt) {
        //TODO 05 Überarbeiten Sie die Update-Methode derart, dass ein Player-Objekt nicht den Bildschirm verlassen kann und immer zu sehen ist.
        if(direction == 0){
            x = x + speed*dt;
            if (x > Config.WINDOW_WIDTH - 14.5 - width){
                x = Config.WINDOW_WIDTH - 14.5 - width;
            }
        }
        if(direction == 2){
            x = x - speed*dt;
            if (x < 0){
                x = 0;
            }
        }
        if (timer > 0){
            timer -= dt;
        }
        if (debuffTimer > 0) {
            debuffTimer -= dt;
        }
        if (timer <= 0 && buffed){
            speedBuffExpired();
        }if (debuffTimer <= 0 && debuffed){
            debuffExpired();
        }
    }

    @Override
    public void keyPressed(int key) {
        if(key == keyToGoLeft){
            direction = 2;
        }
        if(key == keyToGoRight){
            direction = 0;
        }
    }

    @Override
    public void keyReleased(int key) {
        if(key == keyToGoLeft){
            direction = -1;
        }
        if(key == keyToGoRight){
            direction = -1;
        }
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void receiveSpeedBuff(double buffAmount){
        if (!buffed){
            speedBuff = buffAmount;
            speed += speedBuff;
            timer = 5;
            buffed = true;
        }else {
            timer = 5;
        }

    }
    public void speedBuffExpired(){
        speed -= speedBuff;
        speedBuff = 0;
        buffed = false;
    }

    public void receiveDebuff(double buffAmount){
        if (!debuffed){
            debuff = buffAmount;
            speed += debuff;
            debuffTimer = 5;
            debuffed = true;
        }else {
            debuffTimer = 5;
        }

    }
    public void debuffExpired(){
        speed -= debuff;
        debuff = 0;
        debuffed = false;
    }
}
