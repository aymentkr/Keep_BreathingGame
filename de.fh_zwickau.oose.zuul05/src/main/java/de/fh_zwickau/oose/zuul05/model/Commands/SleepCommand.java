package de.fh_zwickau.oose.zuul05.model.Commands;

import de.fh_zwickau.oose.zuul05.controller.ScreenController;
import de.fh_zwickau.oose.zuul05.model.Game;
import de.fh_zwickau.oose.zuul05.model.Items.MasteryBox;
import de.fh_zwickau.oose.zuul05.model.Items.Player;


/**
 * The type Sleep command.
 */
public class SleepCommand extends Command {
    @Override
    public boolean execute(Player player) {
        player.setHealth(player.getHealth()-75);
        player.removeItem(MasteryBox.getKey());
        player.testloss();
        Game.nextDay();
        if (Game.getCurrentDay() == 10) {
            ScreenController.EndScene("Woohoo! You Won!");
            }
        return false;
        }

    @Override
    public String getDescription() {
        return "Ruhe dich aus und mach dich bereit für den nächsten Tag";
    }
}
