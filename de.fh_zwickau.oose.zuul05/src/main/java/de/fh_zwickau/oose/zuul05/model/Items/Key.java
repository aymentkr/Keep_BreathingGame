package de.fh_zwickau.oose.zuul05.model.Items;

import de.fh_zwickau.oose.zuul05.model.Player;
import de.fh_zwickau.oose.zuul05.model.Room;
import de.fh_zwickau.oose.zuul05.utils.PrintUtil;

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
        Optional<Room> roomOptional = player.getRoomInExitDirection("essenraum");
        if (roomOptional.isPresent()) {
            roomOptional.get().setGeschlossen(false);
            System.out.println("Der Raum ist jetzt aufgeschlossen");
        } else PrintUtil.showMessage("Das ist leider nicht möglich!");
    }
}