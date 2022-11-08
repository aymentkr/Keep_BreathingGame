package de.fh_zwickau.oose.zuul05.model.Items;

public class FruitsItem extends Item{
    /**
     * Constructor for objects of class Item
     *
     * @param name        the name
     * @param description the description
     */
    public FruitsItem(String name, String description) {
        super(name, description);
    }

    @Override
    public void use(Player player) {
        player.setHealth(player.getHealth()+10);
    }
}
