package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.Config;
import my_project.model.*;

import java.awt.*;
import java.util.ArrayList;

/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController {

    //Attribute


    // Referenzen
    private ViewController viewController;  // diese Referenz soll auf ein Objekt der Klasse viewController zeigen. Über dieses Objekt wird das Fenster gesteuert.

    private Player player01;
    private PowerApple powerApple;
    private ArrayList<Apple> allApples = new ArrayList<>();
    private ArrayList<Pear> allPears = new ArrayList<>();

    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse viewController. Diese wird als Parameter übergeben.
     *
     * @param viewController das viewController-Objekt des Programms
     */
    public ProgramController(ViewController viewController) {
        this.viewController = viewController;
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen.
     * Sie erstellt die leeren Datenstrukturen, zu Beginn nur eine Queue
     */
    public void startProgram() {

        for (int i = 0; i < 5; i++) {
            double xPos = Math.random() * (Config.WINDOW_WIDTH - 50) + 50;
            double yPos = Math.random() * (Config.WINDOW_HEIGHT - 50) + 50;
            allApples.add(new Apple(xPos, yPos));
        }


        for (int i = 0; i < 5; i++) {
            double xPos = Math.random() * (Config.WINDOW_WIDTH - 50) + 50;
            double yPos = Math.random() * (Config.WINDOW_HEIGHT - 50) + 50;
            allPears.add(new Pear(xPos, yPos));
        }
        for (Pear p : allPears)
            viewController.draw(p);

        for (Apple a : allApples)
            viewController.draw(a);
        double xPos = Math.random() * (Config.WINDOW_WIDTH - 50) + 50;
        double yPos = Math.random() * (Config.WINDOW_HEIGHT - 50) + 50;
        powerApple = new PowerApple(xPos,yPos);
        viewController.draw(powerApple);
        player01 = new Player(50, Config.WINDOW_HEIGHT - 100);
        viewController.draw(player01);
        viewController.register(player01);
    }

    /**
     * Aufruf mit jeder Frame
     *
     * @param dt Zeit seit letzter Frame
     */
    public void updateProgram(double dt) {
        //TODO 08 Nachdem Sie die TODOs 01-07 erledigt haben: Setzen Sie um, dass im Falle einer Kollision (siehe TODO 06 bzw. 07) zwischen dem Spieler und dem Apfel bzw. dem Spieler und der Birne, die jumpBack()-Methode von dem Apfel bzw. der Birne aufgerufen wird.
        //Weitere TODOs folgen und werden im Unterricht formuliert. Spätestens nach TODO 08 sollte der Aufbau des Projekts durchdacht werden.
        for (Apple a : allApples) {
            if (a.checkAndHandleCollision(player01)) {
                a.jumpBack();
                if (a instanceof PowerApple){
                    PowerApple apple = (PowerApple) a;
                    player01.receiveSpeedBuff(apple.getSpeedBuff());
                }
            }

        }
        for (Pear p : allPears) {
            if (p.checkAndHandleCollision(player01)) {
                p.jumpBack();
            }
        }


    }
    //TODO 06 Fügen Sie eine Methode checkAndHandleCollision(Apple a) hinzu. Diese gibt true zurück, falls das Apple-Objekt mit dem Player-Objekt kollidiert. Nutzen Sie hierzu die collidesWith-Methode der Klasse GraphicalObject.

    public boolean checkAndHandleCollision(Apple a) {
        return a.collidesWith(player01);
    }

    //TODO 07 Fügen Sie eine Methode checkAndHandleCollision(Pear p) hinzu. Diese gibt true zurück, falls das Pear-Objekt mit dem Player-Objekt kollidiert. Nutzen Sie hierzu die collidesWith-Methode der Klasse GraphicalObject.
    public boolean checkAndHandleCollision(Pear p) {
        return p.collidesWith(player01);
    }
}
