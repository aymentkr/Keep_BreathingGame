package de.fh_zwickau.oose.zuul05.model.Commands;

import de.fh_zwickau.oose.zuul05.model.Items.Item;
import de.fh_zwickau.oose.zuul05.model.Player;
import de.fh_zwickau.oose.zuul05.utils.PrintUtil;

import java.util.Optional;

/**
 * The type Use command.
 */
public class UseCommand extends Command{

    @Override
    public boolean execute(Player player) {
        if (hasSecondWord()) {
            Optional<Item> optionalItem = player.getItem(getSecondWord());
            if (optionalItem.isPresent() && optionalItem.get().isAvailable())
                optionalItem.ifPresent(item -> item.use(player));
            else
                System.out.println("Sie haben es schon benutzt");
        }
        else  PrintUtil.showMessage("Sie haben kein gültiges Item");
        return false;
}

    @Override
    public String getDescription() {
        return "Verwende ein entsprechendes Tool";
    }
}
