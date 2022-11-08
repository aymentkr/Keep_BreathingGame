package de.fh_zwickau.oose.zuul05.model.Items;

public class FoodItem extends Item{
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

    }
}
