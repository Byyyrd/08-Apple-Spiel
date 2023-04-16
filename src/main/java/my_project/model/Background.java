package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.util.ArrayList;

/**
 * Die Background-Klasse stellt die Umsetzung eines Objekts für den Hintergrund des Apple-Games dar.
 * Hier werden sogenannte Arrays (zu deutsch: Felder) verwendet, die im Unterricht noch nicht behandelt wurden.
 */

public class Background extends GraphicalObject {

    private ArrayList<double[]> allCaughtPears = new ArrayList<>();
    private Player player01;
    private Player player02;

    //Referenzen
    String chosenPhrase;
    String[] phrases = new String[]{"\"An apple a day keeps the doctor away!\" - England",
            "\"Eat an apple on going to bed, and you’ll keep the doctor from earning his bread.\" - Wales",
            "\"Ein Apfel am Tag, Arzt gespart!\" - Deutschland",
            "\"Una mela al giorno toglie il medico di torno.\" - Italien",
            "\"Jedna jabuka na dan, i doktor ti neće ući u stan.\" - Serbien",
            "\"Günde bir elma Doktoru uzak tutar.\" - Türkei",
            "\"Rojek sêvek doktor dûr dike\" - Kurdisch",
            "\"تفاحة على الريق تغنيك عن الطبيب\" - Arabisch"};


    public Background(){
        chosenPhrase = phrases[(int)(Math.random()*phrases.length)];
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(25,100,0,255);
        drawTool.drawFilledRectangle(0,0,1600,1024);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.formatText("Arial",1,10);
        //drawTool.drawText(450,50,chosenPhrase);

        for (double[] p : allCaughtPears) {
            if (p[2] >= 0) {
                drawTool.drawText(p[0], p[1], "In der Not frisst der Teufel Birnen");
            }else {
                allCaughtPears.remove(allCaughtPears);
            }
        }

        drawTool.formatText("Arial",1,20);

        drawTool.drawText(10,20,"Points P1: " + player01.getPoints());
        drawTool.drawText(10,40,"Multiplier P1: " + player01.getMultiplier());

        drawTool.drawText(10,70,"Points P2: " + player02.getPoints());
        drawTool.drawText(10,90,"Multiplier P2: " + player02.getMultiplier());

        drawTool.formatText("Arial",1,40);
        if (player01.isStunned()){
            drawTool.drawText(300,300,"Player 1 Stunned");
        }
        if (player02.isStunned()){
            drawTool.drawText(300,500,"Player 2 Stunned");
        }
    }

    @Override
    public void update(double dt) {
        for (double[] p : allCaughtPears) {
            p[2] -= dt;
        }
    }

    public void caughtPear(Pear p){
        allCaughtPears.add(new double[]{p.getX(),p.getY(),1});
    }

    public void setPlayer01(Player player01) {
        this.player01 = player01;
    }

    public void setPlayer02(Player player02) {
        this.player02 = player02;
    }
}