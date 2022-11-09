package de.fh_zwickau.oose.zuul05.model.Items;

/**
 * The type Mastery box.
 */
public class MasteryBox extends Item {
    static Key schluessel;

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

    public static Key getKey() {
        return schluessel;
    }

    @Override
    public void use(Player player) {
        player.addItem(schluessel);
    }

    @Override
    public boolean isAvailable() {
        return false;
    }
}