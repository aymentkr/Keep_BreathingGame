package de.fh_zwickau.oose.zuul05.model;

import de.fh_zwickau.oose.zuul05.model.Items.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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
     * The Items.
     */
    ArrayList<Item> items = new ArrayList<>();

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
        StringBuilder returnString = new StringBuilder("Ausgaunge:");
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

    /**
     * Is geschlossen boolean.
     *
     * @return the boolean
     */
    public boolean isGeschlossen() {
        return geschlossen;
    }

    /**
     * Sets geschlossen.
     *
     * @param geschlossen the geschlossen
     */
    public void setGeschlossen(boolean geschlossen) {
        this.geschlossen = geschlossen;
    }

    /**
     * Get geschlossen boolean.
     *
     * @return the boolean
     */
    public boolean getGeschlossen(){
        return geschlossen;
    }

    /**
     * Add item.
     *
     * @param item the item
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Gets item.
     *
     * @param name the name
     * @return the item
     */
    public Optional<Item> getItem(String name) {
        return items.stream()
                .filter(item -> item.getName().equals(name))
                .findFirst();
        // return Optional.ofNullable(stuff.get(name));
    }

    /**
     * Info items.
     *
     * @return string
     */
    public String infoItems(){
        return "[ "+  items.stream().map(Item::getName).collect(Collectors.joining(","))+" ]";
    }

    /**
     * Gets items.
     *
     * @return the items
     */
    public ArrayList<Item> getItems() {
        return items;
    }

}