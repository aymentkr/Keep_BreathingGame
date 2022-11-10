package de.fh_zwickau.oose.zuul05.model.Commands;

import de.fh_zwickau.oose.zuul05.controller.ScreenController;
import de.fh_zwickau.oose.zuul05.model.Game;
import de.fh_zwickau.oose.zuul05.model.Items.Item;
import de.fh_zwickau.oose.zuul05.model.Player;


/**
 * The type Sleep command.
 */
public class SleepCommand extends Command {

    InfoCommand info = new InfoCommand();
    @Override
    public boolean execute(Player player) {
        player.setHealth(player.getHealth()-75);
        player.testloss();
        player.nextDay();
        info.execute(player);
        if (player.getCurrentDay() == 7) {
            ScreenController.EndScene("Woohoo! You Won!");
        }
        for (Item i : player.getStuff().values()) {
            i.setAvailable(true);
        }
        player.removeAllItems();
        player.removeConnection();
        Game.createRooms();
        return false;
    }

    @Override
    public String getDescription() {
        return "Ruhe dich aus und mach dich bereit für den nächsten Tag";
    }
}
