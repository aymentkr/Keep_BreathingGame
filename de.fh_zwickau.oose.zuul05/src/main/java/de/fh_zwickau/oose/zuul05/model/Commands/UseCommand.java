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
            Optional<Item> optionalItem = player.getCurrentRoom().getItem(getSecondWord());
            if (optionalItem.isPresent()) {
                if (optionalItem.get().isAvailable()){
                    player.addItemToHitory(optionalItem.get());
                    optionalItem.ifPresent(item -> item.use(player));
                }
                else System.out.println("Sie haben es schon benutzt");
            }
            else PrintUtil.showMessage("Es ist kein gültiges Item");
        }
        else PrintUtil.showMessage("Was möchten Sie benutzen?");
        return false;
}


    @Override
    public String getDescription() {
        return "Verwende ein entsprechendes Tool";
    }
}
