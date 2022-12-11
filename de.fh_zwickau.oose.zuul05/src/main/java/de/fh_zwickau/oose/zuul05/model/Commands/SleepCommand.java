package de.fh_zwickau.oose.zuul05.model.Commands;

import de.fh_zwickau.oose.zuul05.controller.ScreenController;
import de.fh_zwickau.oose.zuul05.model.Game;
import de.fh_zwickau.oose.zuul05.model.Player;
import de.fh_zwickau.oose.zuul05.utils.PrintUtil;


/**
 * The type Sleep command.
 */
public class SleepCommand extends Command {

    /**
     * The Info.
     */
    InfoCommand info = new InfoCommand();
    @Override
    public boolean execute(Player player) {
        if (player.getCurrentRoom().getShortDescription().equals("im Ruheraum")) {
            // if you sleep, your health will reduce so stay awake ;)
            player.setHealth(player.getHealth() - 75);
            // check if the player still alive
            player.testloss();
            // increment number of days
            player.nextDay();
            // teh game ends when the number of days has passed 7
            if (player.getCurrentDay() == 7) {
                ScreenController.EndScene("Woohoo! You Won!");
            }
            // all items that the player used before are unavaible that's why need to be available again
            player.resetItemHistory();
            // reset the history of the rooms that the player visited before
            player.removeHistory();
            // set the food room locked again
            Game.getEssenraum().setGeschlossen(true);
            // show information about the player
            info.execute(player);
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
