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
import de.fh_zwickau.oose.zuul05.model.Commands.InfoCommand;
import de.fh_zwickau.oose.zuul05.model.Items.DrinkItem;
import de.fh_zwickau.oose.zuul05.model.Items.FoodItem;
import de.fh_zwickau.oose.zuul05.model.Items.FruitItem;
import de.fh_zwickau.oose.zuul05.model.Items.MasteryBox;
import de.fh_zwickau.oose.zuul05.utils.PrintUtil;

public class Game {
    private final Parser parser;
    private static Player player;
    static Room schlaffraum, obstraum, essenraum, getraenkraum, schiffsdach;
    Command info = new InfoCommand();



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
    public static void createRooms(){

        // Räume erzeugen:
        schlaffraum = new Room("im Ruheraum");
        obstraum = new Room("Platz der Kategorie Obst");
        essenraum = new Room("Platz der Kategorie Essen");
        essenraum.setGeschlossen(true);
        getraenkraum = new Room("Platz der Kategorie Getränke");
        schiffsdach = new Room("in der Schiff Oberfläche");

        schiffsdach.addItem(new MasteryBox("masterybox","Solve the quiz to get the key"));
        obstraum.addItem(new FruitItem("apfel",""));
        obstraum.addItem(new FruitItem("banana",""));
        essenraum.addItem(new FoodItem("rindhackfleisch","halal!"));
        getraenkraum.addItem(new DrinkItem("cola",""));

        // Ausgänge aufbauen:
        schlaffraum.setExit("unten", essenraum);
        essenraum.setExit("links", getraenkraum);
        getraenkraum.setExit("links", obstraum);
        schlaffraum.setExit("links",schiffsdach);
        essenraum.setExit("oben", schlaffraum);
        getraenkraum.setExit("recht", essenraum);
        obstraum.setExit("recht",getraenkraum);
        obstraum.setExit("oben",schiffsdach);
        schiffsdach.setExit("recht",schlaffraum);
        schiffsdach.setExit("unten",obstraum);

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
        PrintUtil.showMessage("Danke fürs Spielen! Schönen Tag noch!");
    }

    /**
     * Gibt die Willkommensnachricht für den Spieler aus.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println("Willkommen beim Keep Breathing !");
        PrintUtil.showMessage("das Spiel des Überlebens und des Lebens neuer Abenteuer.");
        System.out.println("Gib 'hilfe' ein, um Hilfe zu bekommen.");
        info.execute(player);
    }

    public Player getPlayer() {
        return player;
    }
    public static Room getEssenraum() {
        return essenraum;
    }

}
