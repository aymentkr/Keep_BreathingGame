package de.fh_zwickau.oose.zuul05.model.Items;

import de.fh_zwickau.oose.zuul05.model.Player;

public class FruitItem extends Item{

    public final int lebenspunkt = 15;

    /**
     * Constructor for objects of class Item
     *
     * @param name        the name
     * @param description the description
     */
    public FruitItem(String name, String description) {
        super(name, description);
    }

    @Override
    public void use(Player player) {
        if (isAvailable()) {
            player.setHealth(player.getHealth() + lebenspunkt);
            setAvailable(false);
        }
    }
}