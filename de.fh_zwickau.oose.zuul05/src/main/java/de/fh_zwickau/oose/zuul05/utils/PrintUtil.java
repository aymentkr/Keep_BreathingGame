package de.fh_zwickau.oose.zuul05.utils;


import de.fh_zwickau.oose.zuul05.model.Commands.CommandWords;
import de.fh_zwickau.oose.zuul05.model.Items.Item;
import de.fh_zwickau.oose.zuul05.model.Player;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

/**
 * The type Print util.
 */
public class PrintUtil {

    /**
     * Show message.
     *
     * @param str the str
     */
    public static void showMessage(String str) {
        PrintStream out = new PrintStream(System.out, true, StandardCharsets.UTF_8);
        out.println(str);
    }

    /**
     * Information dialog.
     *
     * @param title   the title
     * @param header  the header
     * @param message the message
     */
    public static void Information_Dialog(String title, String header , String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Help dialog.
     *
     * @param message the message
     */
    public static void Help_Dialog(String message, CommandWords words) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Hilfe zu Kommandos");
        dialog.setHeaderText("Geben Sie hier das Kommando ein");
        dialog.setContentText(message);
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(s -> Information_Dialog("Information Dialog", null, (words.get(s).getDescription())));
    }

    public static void Use_Dialog(Player player){
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Verwende ein entsprechendes Tool");
        dialog.setHeaderText(null);
        dialog.setContentText("Was möchten Sie benutzen?");
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            Optional<Item> optionalItem = player.getCurrentRoom().getItem(result.get());
            if (optionalItem.isPresent()) {
                if (optionalItem.get().isAvailable()){
                    player.addItemToHitory(optionalItem.get());
                    optionalItem.ifPresent(item -> item.use(player));
                }
                else Information_Dialog("Information Dialog", null,"Sie haben es schon benutzt");
            }
            else Information_Dialog("Information Dialog", null,"Es ist kein gültiges Item");
        }
    }

}