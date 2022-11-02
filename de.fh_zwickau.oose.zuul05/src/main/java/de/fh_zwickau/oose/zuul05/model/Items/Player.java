package de.fh_zwickau.oose.zuul05.model.Items;

import de.fh_zwickau.oose.zuul05.controller.ScreenController;
import de.fh_zwickau.oose.zuul05.model.Game;

import java.util.Optional;
import java.util.Stack;

/**
 * Diese Klasse steht für einen Spieler im Spiel.
 * Ein Spieler befindet sich zu jedem Zeitpunkt des Spiels in einem bestimmten Raum.
 *
 * @author Michael Kolling
 */
public class Player
{
    private Room currentRoom;
    private final Stack<Room> connection;
    private Item key;
    private int health;
    ScreenController controller = null;

    /**
     * Konstruktor für die Player-Klasse.
     */
    public Player() {
        currentRoom = null;
        key = new Key("essenraumschlüssel","Den Schlüssel der Tür zum Essensraum");
        health = 75;
        connection = new Stack<Room>();
    }

    /**
     * Liefert den aktuellen Raum des Spielers zurück.
     *
     * @return the current room
     */
    public Room getCurrentRoom()
    {
        return currentRoom;
    }

    /**
     * Setzt den aktuellen Raum des Spielers.
     *
     * @param room the room
     */
    public void setCurrentRoom(Room room)
    {
        currentRoom = room;
    }

    /**
     * Versuche, in eine bestimmte Richtung zu laufen.
     * Wenn dort eine  Tür ist, wird sich dadurch der aktuelle Raum des Spielers ändern.
     *
     * @param direction the direction
     */
    public void walk(String direction) {
        // Try to leave current room.
        Optional<Room> nextRoom = currentRoom.getExit(direction);
        if (nextRoom.isEmpty())
            System.out.println("Da it keine Tür!");
        else {
            connection.push(getCurrentRoom());
            setCurrentRoom(nextRoom.get());
            System.out.println(nextRoom.get().getLongDescription());
        }
    }

    /**
     * Returnback.
     */
    public void returnback(){
        if (!connection.empty()){
            Room backroom = connection.pop();
            setCurrentRoom(backroom);
            System.out.println(backroom.getLongDescription());
        } else
            System.out.println("Das ist leider nicht möglich!");
    }

    public void sleep() throws Exception {
        health-=75;
        key.makeItUnavailable();
        testloss();
        Game.nextDay();
        if (Game.getCurrentDay() == 10) {
            controller.EndScene("Woohoo! You Won!");
        }
    }


    /**
     * Is alive boolean.
     *
     * @return the boolean
     */
    public boolean isAlive() {
        return health>0;
    }

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void testloss() {
    if (!isAlive()) {
        controller.EndScene("You are dead!");
    }
    }
}
