package de.fh_zwickau.oose.zuul05.Game.commands;

import de.fh_zwickau.oose.zuul05.Game.Player;

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
        return """
    In den zuletzt besuchten Raum wechseln.
    Dies kann nicht verwendet werden, wenn Sie noch nicht bereits bewegt haben.""";
    }
}
