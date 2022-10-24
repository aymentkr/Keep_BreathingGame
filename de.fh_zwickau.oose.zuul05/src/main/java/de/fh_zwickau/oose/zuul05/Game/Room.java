package de.fh_zwickau.oose.zuul05.Game;
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

/**
 * 
 * Die Klasse "Room" stellt einen Raum (Ort) in der Spielewelt dar.
 * Die Räume sind miteinander durch Türen verbunden.
 * In jedem Raum sind in der HashMap exits die Ausgänge in alle möglichen Richtungen
 * als Referenz auf den dann erreichten Zielraum gespeichert.
 * 
 * @author  Michael Kolling and David J. Barnes
 */

public class Room 
{
    private String description;
    /**
     * Diese HashMap speichert die Ausgänge des Raumes.
     * Der Schlüssel ist die Bewegungsrichtung, der Eintrag dazu der bei Bewegung in diese
     * Richtung erreichte Raum.
     */
    private HashMap<String, Room> exits;        
    
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
        exits = new HashMap<String, Room>();
    }

    /**
     * Lege die Ausgänge des Raumes fest.
     * @param direction Bewegungsrichtung.
     * @param neighbor Der bei Bewegung in diese Richtung erreichte Zielraum.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * Gib die Raumbeschreibung zurück, so wie sie im Konstruktor angegeben wurde.
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Gib eine längere Beschreibung des Raumes zurück. Beispiel-Format:
     *     Deine Position: die Herrentoilette.
     *     Ausgänge: Norden Westen.
     */
    public String getLongDescription()
    {
        return "Deine Position: " + description + ".\n" + getExitString();
    }
    
    /**
     * Gib einen String zurück, der die Ausgänge des Raumes beschreibt.
     * Beispiel:
     * Ausgänge: Norden Westen.
     */
    private String getExitString()
    {
        String returnString = "Ausgänge:";
        Set<String> keys = exits.keySet();
        for(Iterator<String> iter = keys.iterator(); iter.hasNext(); )
            returnString += " " + iter.next();
        return returnString;
    }

   
    
    /**
     * Gib den Raum zurück, der bei Bewegung in eine Richtung erreicht wird
     * @param direction Bewegungsrichtung.
     * @return erreichter Zielraum, <null>, wenn es in die angegebene Richtung keinen Ausgang gibt.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
}

