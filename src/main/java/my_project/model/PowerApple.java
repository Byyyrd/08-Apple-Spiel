package my_project.model;

import KAGO_framework.view.DrawTool;

import java.awt.*;

public class PowerApple extends Apple{
    private double speedBuff;
    public PowerApple(double x, double y) {
        super(x, y);
        speedBuff = Math.random()*150+50;
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
        drawTool.drawFilledRectangle(x - radius/4,y-radius-radius/2,radius/2,radius/2+5);
    }


}
