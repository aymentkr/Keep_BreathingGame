package de.fh_zwickau.oose.zuul05.utils;


import de.fh_zwickau.oose.zuul05.model.Commands.CommandWords;
import de.fh_zwickau.oose.zuul05.model.Items.Item;
import de.fh_zwickau.oose.zuul05.model.Items.Key;
import de.fh_zwickau.oose.zuul05.model.Player;
import de.fh_zwickau.oose.zuul05.model.quiz.Question;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextInputDialog;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
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

    public static void Choice_Dialog(Question question, Key schluessel,Player player) {
        List<String> choices = new ArrayList<>();
        choices.add("A");
        choices.add("B");
        choices.add("C");
        choices.add("D");
        ChoiceDialog<String> dialog = new ChoiceDialog<>("A", choices);
        dialog.setTitle("Mastery Box Quizz");
        dialog.setHeaderText("""
        Sie müssen ein Rätsel lösen, um einen Schlüssel zu erhalten
        Drücken Sie den Buchstaben für die richtige Antwort A B C D, um zu antworten
        """);
        dialog.setContentText("""
                Frage \s"""+player.getCurrentDay()+": "+question.getQuestion()+"""
                
                
                Option A: \s"""+question.getOptA() + """
                
                Option B: \s"""+question.getOptB() + """
                
                Option C: \s"""+question.getOptC() + """
                
                Option D: \s"""+question.getOptD()
        );
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            if (result.get().equals(question.getAnswer())) {
                Information_Dialog("Information Dialog", "Richtig","Der Raum ist jetzt aufgeschlossen!");
                schluessel.use(player);
            }
            else Information_Dialog("Information Dialog", "Falsch","Sie haben leider den heutigen Versuch verbracht, kommen Sie morgen wieder");
        }
    }
}