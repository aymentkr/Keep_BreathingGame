package de.fh_zwickau.oose.zuul05.Game;

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
    private Stack<Room> connection;
    private boolean key;
    private int health;

    /**
     * Konstruktor für die Player-Klasse.
     */
    public Player() {
        currentRoom = null;
        key = false;
        health = 75;
        connection = new Stack<Room>();
    }

    /**
     * Liefert den aktuellen Raum des Spielers zurück.
     */
    public Room getCurrentRoom()
    {
        return currentRoom;
    }
    
    /**
     * Setzt den aktuellen Raum des Spielers.
     */
    public void setCurrentRoom(Room room)
    {
        currentRoom = room;
    }
    
    /**
     * Versuche, in eine bestimmte Richtung zu laufen.
     * Wenn dort eine  Tür ist, wird sich dadurch der aktuelle Raum des Spielers ändern.
     */
    public void walk(String direction) {
        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom == null)
            System.out.println("Da it keine Tür!");
        else {
            connection.push(getCurrentRoom());
            setCurrentRoom(nextRoom);
            System.out.println(nextRoom.getLongDescription());
        }
    }

    public void returnback(){
        if (!connection.empty()){
            Room backroom = connection.pop();
            setCurrentRoom(backroom);
            System.out.println(backroom.getLongDescription());
        } else
            System.out.println("Das ist leider nicht möglich!");
    }
}
