package de.fh_zwickau.oose.zuul05.model.Commands;

import de.fh_zwickau.oose.zuul05.model.Player;
import de.fh_zwickau.oose.zuul05.utils.PrintUtil;

/**
 * The type Info command.
 */
public class InfoCommand extends Command {
    @Override
    public boolean execute(Player player) {
        System.out.println("Hallo, Ihre aktuellen Lebenspunkte sind : "+player.getHealth());
        System.out.println("Sie sind am "+player.getCurrentDay()+". Tag " );
        System.out.println(7-player.getCurrentDay()+" Tage bleiben bis zur Ankunft des Rettungsschiffes" );
        System.out.println("Ihr aktueller Raum ist : "  + player.getCurrentRoom().getShortDescription());
        player.infoStuff();
return false;
    }

    @Override
    public String getDescription() {
        return "sehe alle Informationen über den Spieler";
    }
}
