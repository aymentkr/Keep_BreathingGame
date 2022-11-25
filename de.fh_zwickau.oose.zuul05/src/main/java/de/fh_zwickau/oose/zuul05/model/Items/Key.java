package de.fh_zwickau.oose.zuul05.model.Items;

import de.fh_zwickau.oose.zuul05.model.Game;
import de.fh_zwickau.oose.zuul05.model.Player;
import de.fh_zwickau.oose.zuul05.model.Room;
import de.fh_zwickau.oose.zuul05.utils.PrintUtil;

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
        if (!Game.getEssenraum().isGeschlossen())
            PrintUtil.showMessage("Sie haben schon die schlüssel genutzt");
        else {
            Game.getEssenraum().setGeschlossen(false);
            System.out.println("Der Raum ist jetzt aufgeschlossen");
        }
    }
}