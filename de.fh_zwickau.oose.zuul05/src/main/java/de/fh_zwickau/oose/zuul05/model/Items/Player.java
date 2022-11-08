package de.fh_zwickau.oose.zuul05.model.Items;

import de.fh_zwickau.oose.zuul05.controller.ScreenController;

import java.util.HashMap;
import java.util.Optional;
import java.util.Stack;

/**
 * Diese Klasse steht für einen Spieler im Spiel.
 * Ein Spieler befindet sich zu jedem Zeitpunkt des Spiels in einem bestimmten Raum.
 *
 * @author Michael Kolling
 */
public class Player {
    private Room currentRoom;
    private final Stack<Room> connection;
    private HashMap<String, Item> stuff;
    private int health;

    /**
     * Konstruktor für die Player-Klasse.
     */
    public Player() {
        currentRoom = null;
        health = 75;
        connection = new Stack<Room>();
        stuff = new HashMap<>();
    }

    /**
     * Liefert den aktuellen Raum des Spielers zurück.
     *
     * @return the current room
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * Setzt den aktuellen Raum des Spielers.
     *
     * @param room the room
     */
    public void setCurrentRoom(Room room) {
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
    public void returnback() {
        if (!connection.empty()) {
            Room backroom = connection.pop();
            setCurrentRoom(backroom);
            System.out.println(backroom.getLongDescription());
        } else
            System.out.println("Das ist leider nicht möglich!");
    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void testloss() {
        if (health <= 0) {
            ScreenController.EndScene("You are dead!");
        }
    }

    public Optional<Item> getItem(String name) {
        return Optional.ofNullable(stuff.get(name));
    }

    public void addItem(Item item) {
        stuff.put(item.getName(), item);
    }

    public void removeItem(Item item) {
        stuff.remove(item.getName());
    }
}