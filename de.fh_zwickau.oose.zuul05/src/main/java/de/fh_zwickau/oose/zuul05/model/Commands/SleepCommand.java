package de.fh_zwickau.oose.zuul05.model.Commands;

import de.fh_zwickau.oose.zuul05.controller.ScreenController;
import de.fh_zwickau.oose.zuul05.model.Game;
import de.fh_zwickau.oose.zuul05.model.Items.FoodItem;
import de.fh_zwickau.oose.zuul05.model.Items.Item;
import de.fh_zwickau.oose.zuul05.model.Items.MasteryBox;
import de.fh_zwickau.oose.zuul05.model.Items.Player;


/**
 * The type Sleep command.
 */
public class SleepCommand extends Command {
    @Override
    public boolean execute(Player player) {
        player.setHealth(player.getHealth()-75);
        player.testloss();
        player.nextDay();
        System.out.println("guten morgen  dein Aktuel lebensPunkte equals : "+player.getHealth());
        System.out.println("du bist am "+player.getCurrentDay()+". tag " );
        System.out.println(7-player.getCurrentDay()+" Tage bleiben bis zur Ankunft des Rettungsschiffes " );

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
