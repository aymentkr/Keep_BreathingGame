package de.fh_zwickau.oose.zuul05.model.Items;

import de.fh_zwickau.oose.zuul05.model.Player;

public class DrinkItem extends Item{

    public final int lebenspunkt = 10;

    /**
     * Constructor for objects of class Item
     *
     * @param name        the name
     * @param description the description
     */
    public DrinkItem(String name, String description) {
        super(name, description);
    }

    @Override
    public void use(Player player) {
        healing(player,lebenspunkt);
    }
}