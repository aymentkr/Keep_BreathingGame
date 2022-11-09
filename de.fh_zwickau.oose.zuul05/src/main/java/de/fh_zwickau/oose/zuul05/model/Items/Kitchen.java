package de.fh_zwickau.oose.zuul05.model.Items;

public class Kitchen extends Item{
    static FoodItem food;
    /**
     * Constructor for objects of class Item
     *
     * @param name        the name
     * @param description the description
     */
    public Kitchen(String name, String description) {
        super(name, description);
        food=new FoodItem("food","fügt 55 punkt zum lebenspunkte");
    }

    @Override
    public void use(Player player) {
        player.addItem(food);
    }

    @Override
    public boolean isAvailable() {
        return false;
}
}