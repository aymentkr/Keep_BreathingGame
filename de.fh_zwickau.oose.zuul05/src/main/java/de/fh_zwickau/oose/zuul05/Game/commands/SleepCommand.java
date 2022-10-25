package de.fh_zwickau.oose.zuul05.Game.commands;

import de.fh_zwickau.oose.zuul05.Game.Player;

/**
 * The type Sleep command.
 */
public class SleepCommand extends Command {
    @Override
    public boolean execute(Player player) {
        return false;
    }

    @Override
    public String getDescription() {
        return "Ruhe dich aus und mach dich bereit für den nächsten Tag";
    }
}
