package my_project.model;

import KAGO_framework.model.GraphicalObject;
import my_project.Config;

public class Fruit extends GraphicalObject {
    protected double speed;
    protected double startX;

    public Fruit(double x, double y) {
        this.x = x;
        this.y = y;
        speed = 150;
    }
    @Override
    public void update(double dt) {
        //TODO 01 Ein Apfel soll von oben herab fallen. Sobald er unten den Bildschirmrand berührt wird die Methode jumpBack() aufgerufen (siehe TODO 02).
        //TODO 03 Eine Birne soll von oben herab fallen. Sobald sie unten den Bildschirmrand berührt wird die Methode jumpBack() aufgerufen (siehe TODO 04).
        this.y += speed * dt;
        if (y > Config.WINDOW_HEIGHT){
            jumpBack();
        }
    }

    //TODO 02 Lege eine Methode jumpBack() an, die bei Aufruf das Apple-Objekt oben am oberen Bildschirmrand an einer zufälligen x-Position positioniert.
    //TODO 04 Lege eine Methode jumpBack() an, die bei Aufruf das Pear-Objekt oben am oberen Bildschirmrand an einer zufälligen x-Position positioniert.
    public void jumpBack(){
        if (radius != 0){
            this.y = -2-radius;
            this.x = Math.random()*(Config.WINDOW_WIDTH-2*radius) + radius;

        }
        else if (height != 0 && width != 0){
            this.y = -2-height;
            this.x = Math.random()*(Config.WINDOW_WIDTH-width);
            startX = x;
        }
        else{
            throw new IllegalArgumentException();
        }
    }
    //TODO 06 Fügen Sie eine Methode checkAndHandleCollision(Apple a) hinzu. Diese gibt true zurück, falls das Apple-Objekt mit dem Player-Objekt kollidiert. Nutzen Sie hierzu die collidesWith-Methode der Klasse GraphicalObject.
    //TODO 07 Fügen Sie eine Methode checkAndHandleCollision(Pear p) hinzu. Diese gibt true zurück, falls das Pear-Objekt mit dem Player-Objekt kollidiert. Nutzen Sie hierzu die collidesWith-Methode der Klasse GraphicalObject.
    public boolean checkAndHandleCollision(Player player){
        return this.collidesWith(player);
    }
}
