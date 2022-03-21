package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class Apple extends GraphicalObject {

    //Attribute
    private double speed;
    private double size;

    public Apple(double x, double y){
        this.x = x;
        this.y = y;
        speed = 150;
        size = 30;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(255,0,0,255);
        drawTool.drawFilledCircle(x,y,size);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawCircle(x,y,size);
    }

    @Override
    public void update(double dt) {
        //TODO 01 Ein Apfel soll von oben herab fallen. Sobald er unten den Bildschirmrand berührt wird die Methode jumpBack() aufgerufen (siehe TODO 02).
    }

    //TODO 02 Lege eine Methode jumpBack() an, die bei Aufruf das Apple-Objekt oben am oberen Bildschirmrand an einer zufälligen x-Position positioniert.
}
