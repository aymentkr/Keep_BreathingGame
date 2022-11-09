package de.fh_zwickau.oose.zuul05.model.Items;

/**
 * The type Food item.
 */
public class FoodItem extends Item {


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
        if (isAvailable()) {
            player.setHealth(player.getHealth() + lebenspunkt);
            setAvailable(false);
        }
    }

}