package de.fh_zwickau.oose.zuul05.model.Items;

import de.fh_zwickau.oose.zuul05.model.Commands.Command;
import de.fh_zwickau.oose.zuul05.model.Commands.GoCommand;
import de.fh_zwickau.oose.zuul05.model.Game;

/**
 * The type Key.
 */
public class Key extends Item {

    /**
     * Constructor for objects of class Item
     *
     * @param name        the name
     * @param description the description
     */
    public Key(String name, String description) {
        super(name, description);
    }

    @Override
    public boolean isAvailable() {
        //kann man das optional machen??
        Player player = new Player();
        if (player.getItem("schluessel").isPresent()) {
            return available = true;
        } else {
            System.out.println("Sie haben kein schluessel");
        }
        return available = false;

    }

    @Override
    public void use(Player player) {
        GoCommand goCommand = new GoCommand();
        if (player.getCurrentRoom() == Game.Rooms.get("sleep")) {
            if (goCommand.getSecondWord().equals("unten")) {
                if (isAvailable()) {
                    //  goCommand.execute(player);
                    player.setCurrentRoom(Game.Rooms.get("food"));
                    player.removeItem(new Key("schluessel", "oeffnet essensRaum"));
                } else System.out.println("You need to get the key first!");
            } else if (player.getCurrentRoom() == Game.Rooms.get("drink")) {
                if (goCommand.getSecondWord().equals("recht")) {
                    if (isAvailable()) {
                        //  goCommand.execute(player);
                        player.setCurrentRoom(Game.Rooms.get("food"));
                        player.removeItem(new Key("schluessel", "oeffnet essensRaum"));
                    } else System.out.println("You need to get the key first!");
                }
            }
        }
    }
}