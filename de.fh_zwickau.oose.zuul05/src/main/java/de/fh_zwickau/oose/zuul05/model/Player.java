package de.fh_zwickau.oose.zuul05.model;

import de.fh_zwickau.oose.zuul05.controller.ScreenController;
import de.fh_zwickau.oose.zuul05.model.Items.Item;
import de.fh_zwickau.oose.zuul05.model.Items.Key;
import de.fh_zwickau.oose.zuul05.utils.PrintUtil;

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
    private final Stack<Room> roomHistory = new Stack<>();
    private final HashMap<String, Item> stuff;
    private int health;
    private int day;

    /**
     * Konstruktor für die Player-Klasse.
     */
    public Player() {
        currentRoom = null;
        health = 100;
        day = 1;
        stuff = new HashMap<>();
        // addItem(new Key("schluessel", "Den Schlüssel der Tür zum Essensraum"));
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
            PrintUtil.showMessage("Da ist keine Tür!");
        else if (nextRoom.get().isGeschlossen())
            PrintUtil.showMessage("Die Tür ist geschlossen! Du brauchst noch den Schluessel von der schiff Oberfläche, um hier hineinzukommen.");
        else {
            roomHistory.push(getCurrentRoom());
            setCurrentRoom(nextRoom.get());
            PrintUtil.showMessage(nextRoom.get().getLongDescription());
        }
    }

    /**
     * Returnback.
     */
    public void back() {
        if (!roomHistory.empty()) {
            Room backroom = roomHistory.pop();
            setCurrentRoom(backroom);
            System.out.println(backroom.getLongDescription());
        } else
            PrintUtil.showMessage("Das ist leider nicht möglich!");
    }


    /**
     * Gets health.
     *
     * @return the health
     */
    public int getHealth() {
        return health;
    }

    /**
     * Sets health.
     *
     * @param health the health
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Testloss.
     */
    public void testloss() {
        if (health <= 0) {
            ScreenController.EndScene("You are dead!");
        }
    }

    /**
     * Gets item.
     *
     * @param name the name
     * @return the item
     */
    public Optional<Item> getItem(String name) {
        return Optional.ofNullable(stuff.get(name));
    }

    /**
     * Get stuff hash map.
     *
     * @return the hash map
     */
    public HashMap<String, Item> getStuff(){
        return stuff;
    }

    /**
     * Add item.
     *
     * @param item the item
     */
    public void addItem(Item item) {
        item.setAvailable(true);
        stuff.put(item.getName(), item);
    }


    /**
     * Remove item.
     *
     * @param item the item
     */
    public void removeItem(Item item) {
        item.setAvailable(false);
        stuff.remove(item.getName());
    }

    /**
     * Remove all items.
     */
    public void removeAllItems() {
        stuff.clear();
    }

    /**
     * Remove connection.
     */
    public void removeConnection(){
        roomHistory.clear();
    }

    /**
     * Next day.
     */
    public void nextDay(){
        day++;
    }

    /**
     * Get current day int.
     *
     * @return the int
     */
    public int getCurrentDay(){
        return day;
    }

    /**
     * Gets room in exit direction.
     *
     * @param direction the direction
     * @return the room in exit direction
     */
    public Optional<Room> getRoomInExitDirection(String direction) {
        return currentRoom.getExit(direction);
    }
}