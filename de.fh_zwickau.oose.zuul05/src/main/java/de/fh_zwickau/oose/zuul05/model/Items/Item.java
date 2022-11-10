package de.fh_zwickau.oose.zuul05.model.Items;

import de.fh_zwickau.oose.zuul05.model.Player;

/**
 * The type Item.
 */
public abstract class Item {
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
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }


    /**
     * This returns the description of an item.
     *
     * @return description description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets item description.
     *
     * @return the item description
     */
    public String getItemDescription() {
        String itemString = "This Item called :";
        itemString = itemString + this.name + "\n";
        itemString = itemString + "Description: " + this.description + "\n";
        return itemString;
    }

    /**
     * Use.
     *
     * @param player the player
     */
    public abstract void use(Player player);

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * Is available boolean.
     *
     * @return the boolean
     */
    public boolean isAvailable(){
        return available;
    }

}

