package de.fh_zwickau.oose.zuul05.model.Items;

import de.fh_zwickau.oose.zuul05.model.Player;

/**
 * The type Food item.
 */
public class FoodItem extends Item {


    /**
     * The Lebenspunkt.
     */
    public final int lebenspunkt = 55;

    /**
     * Constructor for objects of class Item
     *
     * @param name        the name
     * @param description the description
     */
    public FoodItem(String name, String description) {
        super(name, description);
    }


    @Override
    public void use(Player player) {
        healing(player,lebenspunkt);
    }

}