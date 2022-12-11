package de.fh_zwickau.oose.zuul05.model.Commands;

import de.fh_zwickau.oose.zuul05.model.Player;
import de.fh_zwickau.oose.zuul05.utils.PrintUtil;

/**
 * The type Info command.
 */
public class InfoCommand extends Command {
    @Override
    public boolean execute(Player player) {
        PrintUtil.Information_Dialog(
                "Information Dialog",
                "Hallo, Ihre aktuellen Lebenspunkte sind : "+player.getHealth(),
                "Sie sind am " +player.getCurrentDay()+". Tag \n" +
                        (7-player.getCurrentDay())+" Tage bleiben bis zur Ankunft des Rettungsschiffes \n"+
                        "Ihr aktueller Raum ist : "  + player.getCurrentRoom().getShortDescription()
                        //player.getCurrentRoom().infoItems()
        );
return false;
    }

    @Override
    public String getDescription() {
        return "sehe alle Informationen über den Spieler";
    }
}
