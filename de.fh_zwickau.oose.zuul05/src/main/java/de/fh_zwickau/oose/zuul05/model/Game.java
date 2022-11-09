package de.fh_zwickau.oose.zuul05.model;
/*
 *
 * Dies ist die Hauptklasse des Spiels "Die Welt von Zuul"
 *
 * "Die Welt von Zuul" ist ein einfaches textbasiertes Adventure-Spiel.
 * Der Spieler kann in der Welt herumlaufen.
 * Um das Spiel interessanter zu machen, sollten weitere Kommandos eingebaut werden!
 *
 * Um das Spiel zu spielen, wird in der main-Methode eine Instanz dieser Klasse
 * erzeugt und die play-Methode aufgerufen.
 *
 * Diese Klasse sorgt dafür, dass alle nötigen Objekte erzeugt und
 * initialisiert werden: Es werden alle Räume angelegt, der Parser
 * erzeugt und das Spiel gestartet.
 *
 * In einer Endlosschleife wird dann dafür gesorgt, dass eingegebene Kommandos
 * analysiert und ausgeführt werden.
 *
 * @author  Michael Kolling and David J. Barnes
 */
import de.fh_zwickau.oose.zuul05.model.Commands.Command;
import de.fh_zwickau.oose.zuul05.model.Items.Player;
import de.fh_zwickau.oose.zuul05.model.Items.Room;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    private final Parser parser;
    private static Player player;


    /**
     * Konstruktor der Game-Klasse, legt auch die Raumstruktur fest.
     */
    public Game()
    {
        player = new Player();
        parser = new Parser();
        createRooms();
    }

    /**
     * Die main-Methode instanziiert eine neue Game-Klasse und startet das Spiel.
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }

    /**
     * Erzeugt alle Räume und die Verbindungen zwischen ihnen.
     */
    public static void createRooms()
    {
        Room schlaffraum, obstraum, essenraum, getraenkraum, schiffsdach;

        // Räume erzeugen:
        schlaffraum = new Room("im Ruheraum");
        obstraum = new Room("Platz der Kategorie Obst");
        essenraum = new Room("Platz der Kategorie Essen");
        essenraum.setGeschlossen(true);
        getraenkraum = new Room("Platz der Kategorie Getraenke");
        schiffsdach = new Room("in der Schiff Oberfläche");



        // Ausgänge aufbauen:
        schlaffraum.setExit("unten", essenraum);
        essenraum.setExit("links", getraenkraum);
        getraenkraum.setExit("links", obstraum);
        schlaffraum.setExit("links",schiffsdach);
        essenraum.setExit("oben", schlaffraum);
        getraenkraum.setExit("recht", essenraum);
        obstraum.setExit("recht",obstraum);
        obstraum.setExit("oben",schiffsdach);

        schiffsdach.setExit("recht",schlaffraum);

        // Der Spieler startet das Spiel draußen vor der Hochschule:
        player.setCurrentRoom(schlaffraum);
    }


    /**
     *  Die Hauptroutine des Spiels
     *  Läuft in einer Schleife, bis das Spiel beendet wird.
     */
    public void play()
    {
        printWelcome();

        // Hier werden wiederholt Kommando-Eingaben gelesen und die
        // Kommandos ausgeführt, bis das Spiel beendet ist.

        boolean finished = false;
        while(! finished) {
            Command command = parser.getCommand();
            finished = command.execute(player);
        }
        System.out.println("Danke fürs Spielen! Schönen Tag noch!");
    }

    /**
     * Gibt die Willkommensnachricht für den Spieler aus.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Willkommen beim Keep Breathing !");
        System.out.println("das Spiel des Überlebens und des Lebens neuer Abenteuer.");
        System.out.println("Gib 'hilfe' ein, um Hilfe zu bekommen.");
        System.out.println();
        System.out.println(player.getCurrentRoom().getLongDescription());
    }

    public Player getPlayer() {
        return player;
    }

}
