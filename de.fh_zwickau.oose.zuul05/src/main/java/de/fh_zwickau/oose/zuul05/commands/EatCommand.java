package de.fh_zwickau.oose.zuul05.commands;

import de.fh_zwickau.oose.zuul05.Player;

/**
 * The type Eat command.
 */
public class EatCommand extends Command {
    @Override
    public boolean execute(Player player) {
        return false;
    }

    @Override
    public String getDescription() {
        return "Selbst füttern";
    }
}
