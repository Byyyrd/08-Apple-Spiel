package my_project.model;

import KAGO_framework.view.DrawTool;

import java.awt.*;

public class PowerPear extends Pear {
    private double speedBuff;
    public PowerPear(double x, double y) {
        super(x, y);
        speedBuff = Math.random()*-50-50;
    }

    public void setSpeedBuff(double speedBuff) {
        this.speedBuff = speedBuff;
    }

    public double getSpeedBuff() {
        return speedBuff;
    }

    @Override
    public void draw(DrawTool drawTool) {
        super.draw(drawTool);
        drawTool.setCurrentColor(new Color(66,40,14));
        drawTool.drawFilledRectangle(x + width/2-width/4,y-height/4,width/2,height/4);
    }
}
