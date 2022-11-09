package de.fh_zwickau.oose.zuul05.model.Items;

import de.fh_zwickau.oose.zuul05.model.Commands.Command;
import de.fh_zwickau.oose.zuul05.model.Commands.GoCommand;
import de.fh_zwickau.oose.zuul05.model.Game;

import java.util.Optional;

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
    public void use(Player player) {
        Optional<Room> roomOptional = player.getCurrentRoom().getExit("essenraum");
        if (roomOptional.isPresent()) {
            roomOptional.get().setGeschlossen(false);
            System.out.println("Der Raum ist jetzt aufgeschlossen");
        }

        /*
        GoCommand goCommand = new GoCommand();
        if (isAvailable()) {
            Game.Rooms.get("food").setGeschlossen(false);
            goCommand.execute(player);
            player.removeItem(this);
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

        */
    }
}