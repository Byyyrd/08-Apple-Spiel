package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.Config;
import my_project.model.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;
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
    private Player player02;
    private Banana banana;
    private Background background;
    /*private ArrayList<Apple> allApples = new ArrayList<>();
    private ArrayList<Pear> allPears = new ArrayList<>();*/
    private ArrayList<Fruit> allFruits = new ArrayList<>();

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

        background = new Background();
        viewController.draw(background);

        for (int i = 0; i < 13; i++) {
            double xPos = Math.random() * (Config.WINDOW_WIDTH - 50) + 50;
            double yPos = Math.random() * (Config.WINDOW_HEIGHT - 50) + 50;
            if (i < 5) {
                allFruits.add(new Apple(xPos, yPos));
            } else if (i < 10) {
                allFruits.add(new Pear(xPos, yPos));
            } else if (i == 10) {
                allFruits.add(new PowerApple(xPos, yPos));
            } else if (i == 11) {
                allFruits.add(new PowerPear(xPos, yPos));
            } else {
                allFruits.add(new Banana(xPos, yPos));
            }
        }

        for (Fruit f : allFruits)
            viewController.draw(f);

        player01 = new Player(50, Config.WINDOW_HEIGHT - 100, KeyEvent.VK_A, KeyEvent.VK_D, Color.black);
        viewController.draw(player01);
        viewController.register(player01);

        player02 = new Player(100, Config.WINDOW_HEIGHT - 100, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, Color.white);
        viewController.draw(player02);
        viewController.register(player02);

        background.setPlayer01(player01);
        background.setPlayer02(player02);
    }

    /**
     * Aufruf mit jeder Frame
     *
     * @param dt Zeit seit letzter Frame
     */
    public void updateProgram(double dt) {
        //TODO 08 Nachdem Sie die TODOs 01-07 erledigt haben: Setzen Sie um, dass im Falle einer Kollision (siehe TODO 06 bzw. 07) zwischen dem Spieler und dem Apfel bzw. dem Spieler und der Birne, die jumpBack()-Methode von dem Apfel bzw. der Birne aufgerufen wird.
        //Weitere TODOs folgen und werden im Unterricht formuliert. Spätestens nach TODO 08 sollte der Aufbau des Projekts durchdacht werden.
        Collision(player01);
        Collision(player02);

    }
    //TODO 06 Fügen Sie eine Methode checkAndHandleCollision(Apple a) hinzu. Diese gibt true zurück, falls das Apple-Objekt mit dem Player-Objekt kollidiert. Nutzen Sie hierzu die collidesWith-Methode der Klasse GraphicalObject.

   /* public boolean checkAndHandleCollision(Apple a) {
        return a.collidesWith(player01);
    }*/

    //TODO 07 Fügen Sie eine Methode checkAndHandleCollision(Pear p) hinzu. Diese gibt true zurück, falls das Pear-Objekt mit dem Player-Objekt kollidiert. Nutzen Sie hierzu die collidesWith-Methode der Klasse GraphicalObject.
    /*public boolean checkAndHandleCollision(Pear p) {
        return p.collidesWith(player01);
    }*/

    private void Collision(Player player) {
        for (Fruit f : allFruits) {
            if (f.checkAndHandleCollision(player)) {
                if (f instanceof Apple) {
                    player.receivePoints(Config.POINTS_BASE * player.getMultiplier());
                    if (f instanceof PowerApple) {
                        PowerApple apple = (PowerApple) f;
                        player.receiveSpeedBuff(apple.getSpeedBuff());
                        player.receivePoints(Config.POINTS_BASE * player.getMultiplier());
                    }
                    player.gainMultiplier();
                }
                if (f instanceof Pear) {
                    player.receivePoints(-Config.POINTS_BASE + player.getMultiplier());
                    Pear p = (Pear) f;
                    background.caughtPear(p);
                    if (f instanceof PowerPear) {
                        PowerPear powerPear = (PowerPear) f;
                        player02.receiveDebuff(powerPear.getSpeedBuff());
                        player.receivePoints(-Config.POINTS_BASE + player.getMultiplier());
                    }
                    player.loseMultiplier();
                }
                if (f instanceof Banana){
                    player.getStunned();
                }
                f.jumpBack();
            }
        }
    }
}
