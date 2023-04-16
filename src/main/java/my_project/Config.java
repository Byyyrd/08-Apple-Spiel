package my_project;

/**
 * In dieser Klasse werden globale, statische Einstellungen verwaltet.
 * Die Werte können nach eigenen Wünschen angepasst werden.
 */
public class Config {

    // Titel des Programms (steht oben in der Fenstertitelzeile)
    public final static String WINDOW_TITLE = "Apple-Game-Projekt auf Grundlage des KAGO-Frameworks";

    // Konfiguration des Standardfensters: Anzeige und Breite des Programmfensters (Width) und Höhe des Programmfensters (Height)
    public final static boolean SHOW_DEFAULT_WINDOW = true;
    public final static int WINDOW_WIDTH = 1000;
    public final static int WINDOW_HEIGHT = 1000+29;   // Effektive Höhe ist etwa 29 Pixel geringer (Titelleiste wird mitgezählt)


    // Weitere Optionen für das Projekt
    public final static boolean useSound = true;

    //Haha Funny
    public final static double WIGGLE_RANGE = 30;
    public final static double WIGGLE_SPEED_PERCENTAGE = 0.5;

    //Points
    public final static double POINTS_BASE = 5;
}
