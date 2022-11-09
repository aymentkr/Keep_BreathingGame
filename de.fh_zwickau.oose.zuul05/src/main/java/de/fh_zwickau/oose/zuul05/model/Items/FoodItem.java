package de.fh_zwickau.oose.zuul05.model.Items;

import java.util.HashMap;

public class FoodItem extends Item {


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
        if (isAvailable()) {
            player.setHealth(player.getHealth() + 55);
            player.removeItem(new FoodItem("food", "fügt 55 punkt zum lebenspunkte"));
        }
    }

    @Override
    public boolean isAvailable() {

        //kann man das optional machen??
        Player player = new Player();
        if (player.getItem("food").isPresent()) {
            return available = true;
        } else {
            System.out.println("Sie haben kein food");
        }
        return available = false;

    }
}