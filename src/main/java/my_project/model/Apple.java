package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;

public class Apple extends Fruit {
    public Apple(double x, double y){
        super(x,y);
        radius = 30;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(255,0,0,255);
        drawTool.drawFilledCircle(x,y,radius);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawCircle(x,y,radius);
    }

    @Override
    public void update(double dt) {
        super.update(dt);
    }
}
