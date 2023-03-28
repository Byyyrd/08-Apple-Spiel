package my_project.model;

import KAGO_framework.view.DrawTool;

import java.awt.*;

public class Banana extends Fruit {
    public Banana(double x, double y) {
        super(x, y);
        width = 20;
        height = 50;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(new Color(253, 210, 57));
        drawTool.drawFilledRectangle(x, y, width, height);
        drawTool.setCurrentColor(0, 0, 0, 255);
        drawTool.drawRectangle(x, y, width, height);
    }

    @Override
    public void update(double dt) {
        super.update(dt);

    }
}
