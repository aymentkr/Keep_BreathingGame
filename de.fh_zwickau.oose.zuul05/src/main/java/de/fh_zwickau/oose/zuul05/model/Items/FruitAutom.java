package de.fh_zwickau.oose.zuul05.model.Items;

public class FruitAutom extends  Item{
    static  FoodItem fruit;
    Player player;
    /**
     * Constructor for objects of class Item
     *
     * @param name        the name
     * @param description the description
     */
    public FruitAutom(String name, String description) {
        super(name, description);
        fruit=new FoodItem("fruit","fügt 15punkte zum lebenspunkte");
    }

    @Override
    public void use(Player player) {
        if(isAvailable())
        player.addItem(fruit);
    }

    @Override
    public boolean isAvailable() {
        //kann man das optional machen??
        player=new Player();
        if(player.getItem("fruit").isPresent()){

            System.out.println("Sie haben schön fruit gehabt");
            return false;

        }else{
            player.addItem(fruit);
            return true;
        }

    }
}
