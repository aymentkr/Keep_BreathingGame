package de.fh_zwickau.oose.zuul05.model.Items;

import java.util.HashMap;
import java.util.Optional;
import java.util.Set;

/**
 * Die Klasse "Room" stellt einen Raum (Ort) in der Spielewelt dar.
 * Die Räume sind miteinander durch Türen verbunden.
 * In jedem Raum sind in der HashMap exits die Ausgänge in alle möglichen Richtungen
 * als Referenz auf den dann erreichten Zielraum gespeichert.
 *
 * @author Michael Kolling and David J. Barnes
 */
public class Room
{
    private final String description;
    private boolean geschlossen = false;
    /**
     * Diese HashMap speichert die Ausgänge des Raumes.
     * Der Schlüssel ist die Bewegungsrichtung, der Eintrag dazu der bei Bewegung in diese
     * Richtung erreichte Raum.
     */
    private final HashMap<String, Room> exits;

    /**
     * Konstruktor der Klasse Raum.
     * Lege einen Raum mit einer Raumbeschreibung (description) an.
     * Die Raumbeschreibung ist so etwas wie
     * "der Fahrstuhl" oder "die Herrentoilette".
     * Der neu erzeugte Raum hat noch keine Ausgänge.
     *
     * @param description Die Raumbeschreibung.
     */
    public Room(String description)
    {
        this.description = description;
        exits = new HashMap<>();
    }

    /**
     * Lege die Ausgänge des Raumes fest.
     *
     * @param direction Bewegungsrichtung.
     * @param neighbor  Der bei Bewegung in diese Richtung erreichte Zielraum.
     */
    public void setExit(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }

    /**
     * Gib die Raumbeschreibung zurück, so wie sie im Konstruktor angegeben wurde.
     *
     * @return the short description
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Gib eine längere Beschreibung des Raumes zurück. Beispiel-Format:
     * Deine Position: die Herrentoilette.
     * Ausgänge: Norden Westen.
     *
     * @return the long description
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
    private String getExitString() {
        StringBuilder returnString = new StringBuilder("Ausgänge:");
        Set<String> keys = exits.keySet();
        for (String key : keys) returnString.append(" ").append(key);
        return returnString.toString();
    }


    /**
     * Gib den Raum zurück, der bei Bewegung in eine Richtung erreicht wird
     *
     * @param direction Bewegungsrichtung.
     * @return erreichter Zielraum, <null>, wenn es in die angegebene Richtung keinen Ausgang gibt.
     */
    public Optional<Room> getExit(String direction) {
        //Optional.ofNullable - allows passed parameter to be null
        return Optional.ofNullable(exits.get(direction));
    }

    public boolean isGeschlossen() {
        return geschlossen;
    }

    public void setGeschlossen(boolean geschlossen) {
        this.geschlossen = geschlossen;
    }
}

