package de.fh_zwickau.oose.zuul05.model.Items;

public class WaterItem extends Item{
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
            player.setHealth(player.getHealth() + 10);
            player.removeItem(new WaterItem("bottle","fügt 10 punkt zum lebenspunkte"));

        }
    }
    @Override
    public boolean isAvailable() {
        Player player=new Player();
        if(player.getItem("bottle").isPresent()){
            return available=true;
        }else{
            System.out.println("Sie haben kein wasser flasche");
        }
        return available=false;
    }
}