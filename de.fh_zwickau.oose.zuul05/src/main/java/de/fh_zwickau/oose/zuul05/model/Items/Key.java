package de.fh_zwickau.oose.zuul05.model.Items;

import de.fh_zwickau.oose.zuul05.model.Game;

/**
 * The type Key.
 */
public class Key extends Item{

    /**
     * Constructor for objects of class Item
     *
     * @param name        the name
     * @param description the description
     */
    public Key(String name, String description) {
        super(name, description);
        makeItUnavailable();
    }

    @Override
    public void use(Player player) {
        if (player.getCurrentRoom() == Game.Rooms.get("food")){
            if (this.isAvailable())player.setCurrentRoom(Game.Rooms.get("food"));
            else System.out.println("You need to get the key first!");
        }
        else System.out.println("You need to go to the Food Room first!");
    }
}
