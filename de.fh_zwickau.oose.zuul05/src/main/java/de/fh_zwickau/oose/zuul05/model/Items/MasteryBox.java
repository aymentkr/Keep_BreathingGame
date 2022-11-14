package de.fh_zwickau.oose.zuul05.model.Items;

import de.fh_zwickau.oose.zuul05.model.Player;

import java.util.HashMap;

/**
 * The type Mastery box.
 */
public class MasteryBox extends Item {
    private final Key schluessel;
  //  private HashMap<Integer,String>

    /**
     * Constructor for objects of class Item
     *
     * @param name        the name
     * @param description the description
     */
    public MasteryBox(String name, String description) {
        super(name, description);
        schluessel = new Key("schluessel", "Den Schlüssel der Tür zum Essensraum");
    }

    @Override
    public void use(Player player) {
        if (player.getItem("schluessel").isPresent())
            System.out.println("Sie haben schon die schluessel");
        else {




            player.addItem(schluessel);
        }
    }



}