package de.fh_zwickau.oose.zuul05.model.Commands;

import de.fh_zwickau.oose.zuul05.model.Player;
import de.fh_zwickau.oose.zuul05.utils.PrintUtil;

public class InfoCommand extends Command {
    @Override
    public boolean execute(Player player) {
        PrintUtil.showMessage("Day : "  + player.getCurrentDay() + "\n"
                + "Health : "  + player.getHealth() + "\n"
                + "Current Room : "  + player.getCurrentRoom().getShortDescription());
        System.out.print("Items : |");
        player.getStuff().forEach((key, value) -> PrintUtil.showMessage(key + "|"));
return false;
    }

    @Override
    public String getDescription() {
        return "sehe alle Informationen über den Spieler";
    }
}
