package de.fh_zwickau.oose.zuul05.model.Commands;

import de.fh_zwickau.oose.zuul05.model.Player;

/**
 * The type Back command.
 */
public class BackCommand extends Command {
    @Override
    public boolean execute(Player player) {
        player.back();
        return false;
    }

    @Override
    public String getDescription() {
        return "Gehe mal zurueck";
    }
}
