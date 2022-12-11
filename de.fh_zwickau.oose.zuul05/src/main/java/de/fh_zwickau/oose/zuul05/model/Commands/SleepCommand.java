package de.fh_zwickau.oose.zuul05.model.Commands;

import de.fh_zwickau.oose.zuul05.model.Game;
import de.fh_zwickau.oose.zuul05.model.Player;
import de.fh_zwickau.oose.zuul05.utils.PrintUtil;


/**
 * The type Sleep command.
 */
public class SleepCommand extends Command {

    @Override
    public boolean execute(Player player) {
        if (player.getCurrentRoom().getShortDescription().equals("im Ruheraum")) {
            // if you sleep, your health will reduce so stay awake ;)
            player.setHealth(player.getHealth() - 75);
            // increment number of days
            player.nextDay();
            // all items that the player used before are unavaible that's why need to be available again
            player.resetItemHistory();
            // reset the history of the rooms that the player visited before
            player.removeHistory();
            // set the food room locked again
            Game.getEssenraum().setGeschlossen(true);
        } else {
            PrintUtil.Information_Dialog("Information Dialog", null,"Du solltest im Ruheraum sein");
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "Ruhe dich aus und mach dich bereit für den nächsten Tag";
    }
}
