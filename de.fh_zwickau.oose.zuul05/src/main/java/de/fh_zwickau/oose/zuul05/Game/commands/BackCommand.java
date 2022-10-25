package de.fh_zwickau.oose.zuul05.Game.commands;

import de.fh_zwickau.oose.zuul05.Game.Player;

/**
 * The type Back command.
 */
public class BackCommand extends Command {
    @Override
    public boolean execute(Player player) {
        return false;
    }

    @Override
    public String getDescription() {
        return "Gehe in den Schlafraum";
    }
}
