package de.fh_zwickau.oose.zuul05;
/**
 * 
 * Die Klasse "Room" stellt einen Raum (Ort) in der Spielewelt dar.
 * Die Räume sind miteinander durch Türen verbunden.
 * In jedem Raum sind in den Variablen northExit, southExit,
 * eastExit und westExit die Ausgänge in die vier möglichen Richungen
 * als Referenz auf den dann erreichten Zielraum gespeichert.
 * Wenn es keinen Ausgang in dieser Richtung gibt, ist diese Referenz <null>.
 * 
 * @author  Michael Kolling and David J. Barnes
 */
public class Room 
{
    public String description;
    public Room northExit;
    public Room southExit;
    public Room eastExit;
    public Room westExit;

    /**
     * Konstruktor der Klasse Raum.
     * Lege einen Raum mit einer Raumbeschreibung (description) an.
     * Die Raumbeschreibung ist so etwas wie
     * "der Fahrstuhl" oder "die Herrentoilette".
     * Der neu erzeugte Raum hat noch keine Ausgänge.
     * @param description Die Raumbeschreibung.
     */
    public Room(String description) 
    {
        this.description = description;
    }

    /**
     * Lege die Ausgänge des Raumes in die vier Himmelsrichtungen fest.
     * Jede Himmelsrichtung führt entweder in einen anderen Raum oder die
     * Referenz ist <null> (wenn es keinen Ausgang gibt).
     * @param north Der Ausgang Richtung Norden.
     * @param east Der Ausgang Richtung Osten.
     * @param south Der Ausgang Richtung Süden.
     * @param west Der Ausgang Richtung Westen.
     */
    public void setExits(Room north, Room east, Room south, Room west) 
    {
        if(north != null)
            northExit = north;
        if(east != null)
            eastExit = east;
        if(south != null)
            southExit = south;
        if(west != null)
            westExit = west;
    }

    /**
     * @return Die Raumbeschreibung.
     */
    public String getDescription()
    {
        return description;
    }

}
