package de.fh_zwickau.oose.zuul05.model.Items;

public class FruitsItem extends Item{
    Player player;
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
        if (isAvailable()) {
            player.setHealth(player.getHealth() + 15);
            player.removeItem(new FruitsItem("obst","fügt 15 punkt zum lebenspunkte"));

        }
    }
    @Override
    public boolean isAvailable() {
        //kann man das optional machen??
        player=new Player();
        if(player.getItem("obst").isPresent()){
            return available=true;
        }else{
            System.out.println("Sie haben kein obst");
        }
        return available=false;

}
}