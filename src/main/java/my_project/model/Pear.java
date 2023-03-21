package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;

public class Pear extends Fruit{

    //Attribute
    private boolean moveRight;


    public Pear(double x, double y){
        super(x,y);
        startX = x;
        width = 25;
        height = 35;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(0,255,0,255);
        drawTool.drawFilledRectangle(x,y,width,height);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawRectangle(x,y,width,height);
    }
    @Override
    public void update(double dt) {
        super.update(dt);

        if (x > startX + Config.WIGGLE_RANGE){
            moveRight = false;
        }
        if (x < startX - Config.WIGGLE_RANGE){
            moveRight = true;
        }
        if (moveRight){
            x += speed * dt * Config.WIGGLE_SPEED_PERCENTAGE;
        }else   {
            x -= speed * dt * Config.WIGGLE_SPEED_PERCENTAGE; //callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~//callus was here uwu~
        }

    }
}

