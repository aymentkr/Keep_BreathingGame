package de.fh_zwickau.oose.zuul05.model.Items;

import java.util.HashMap;

/**
 * The type Item.
 */
public abstract class Item
{
    // instance variables
    private final String name;
    private final String description;
    private boolean available = true;

    /**
     * Constructor for objects of class Item
     *
     * @param name        the name
     * @param description the description
     */
    public Item(String name, String description)
    {
        this.name = name;
        this.description = description;
    }

    /**
     * Is available boolean.
     *
     * @return the boolean
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Make it available.
     */
    public void makeItAvailable() {
        this.available = true;
    }

    /**
     * Make it unavailable.
     */
    public void makeItUnavailable() {
        this.available = false;
    }


    /**
     * This returns the description of an item.
     *
     * @return description description
     */
    public String getDescription()
    {
        return description;
    }


    /**
     * Gets item description.
     *
     * @return the item description
     */
    public String getItemDescription()
    {
        String itemString = "This Item called :";
        itemString = itemString + this.name + "\n";
        itemString = itemString + "Description: " + this.description + "\n";
        itemString = itemString + "\nAvailable: " + this.available;
        return itemString;
    }

    public abstract void use(Player player);
}