package de.fh_zwickau.oose.zuul05.model;
import de.fh_zwickau.oose.zuul05.model.Items.Item;
import de.fh_zwickau.oose.zuul05.utils.PrintUtil;

import java.util.ArrayList;
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
    private final ArrayList<Item> itemHistory = new ArrayList<>();
    private int health;

    private int day;

    /**
     * Konstruktor für die Player-Klasse.
     */
    public Player() {
        currentRoom = null;
        health = 100;
        day = 1;
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
            PrintUtil.Information_Dialog("Information Dialog",null,"Da ist keine Tür!");
        else if (nextRoom.get().isGeschlossen())
            PrintUtil.Information_Dialog("Information Dialog",null,"Die Tür ist geschlossen! Du brauchst noch den Schluessel von der schiff Oberfläche, um hier hineinzukommen.");
        else {
            roomHistory.push(getCurrentRoom());
            setCurrentRoom(nextRoom.get());
            // PrintUtil.Information_Dialog("Information Dialog",null,nextRoom.get().getLongDescription());
        }
    }


    /**
     * Returnback.
     */
    public void back() {
        if (!roomHistory.empty()) {
            Room backroom = roomHistory.pop();
            setCurrentRoom(backroom);
            PrintUtil.Information_Dialog("Information Dialog", null,backroom.getLongDescription());
        } else
            PrintUtil.Information_Dialog("Information Dialog", null,"Das ist leider nicht möglich!");
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
     * Add item to hitory.
     *
     * @param item the item
     */
    public void addItemToHitory(Item item) {
        itemHistory.add(item);
    }


    /**
     * Remove connection.
     */
    public void removeHistory(){
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
     * Reset item history.
     */
    public void resetItemHistory() {
        for (Item item : itemHistory) item.setAvailable(true);
        itemHistory.clear();
    }

}