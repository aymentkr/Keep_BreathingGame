package de.fh_zwickau.oose.zuul05.commands;

import de.fh_zwickau.oose.zuul05.Player;

/**
 * The type Back command.
 */
public class BackCommand extends Command {
    @Override
    public boolean execute(Player player) {
        player.returnback();
        return false;
    }

    @Override
    public String getDescription() {
        return "Gehe mal zurueck";
    }
}
