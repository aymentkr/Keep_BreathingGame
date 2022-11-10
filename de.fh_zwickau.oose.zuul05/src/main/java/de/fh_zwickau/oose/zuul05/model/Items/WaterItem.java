package de.fh_zwickau.oose.zuul05.model.Items;

import de.fh_zwickau.oose.zuul05.model.Player;

public class WaterItem extends Item{

    public final int lebenspunkt = 10;

    /**
     * Constructor for objects of class Item
     *
     * @param name        the name
     * @param description the description
     */
    public WaterItem(String name, String description) {
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