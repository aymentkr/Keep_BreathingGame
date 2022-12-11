package de.fh_zwickau.oose.zuul05.model.Commands;

import de.fh_zwickau.oose.zuul05.model.Player;
import de.fh_zwickau.oose.zuul05.utils.PrintUtil;

/**
 * The type Use command.
 */
public class UseCommand extends Command{

    @Override
    public boolean execute(Player player) {
        PrintUtil.Use_Dialog(player);
        return false;
}


    @Override
    public String getDescription() {
        return "Verwende ein entsprechendes Tool";
    }
}
