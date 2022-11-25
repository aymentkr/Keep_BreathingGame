package de.fh_zwickau.oose.zuul05.model.Commands;
import de.fh_zwickau.oose.zuul05.utils.PrintUtil;

import java.util.HashMap;

/**
 * Diese Klasse enthält alle im Spiel bekannten Kommandowörter.
 * Sie wird genutzt, um eingegebene Kommandos zu erkennen.
 *
 * @author  Michael Kolling and David J. Barnes
 */

public class CommandWords
{
    private static HashMap<String, Command> commands = null;

    /**
     * Konstruktor - Kommandowörter initialisieren
     */
    public CommandWords()
    {
        commands = new HashMap<>();
        commands.put("gehe", new GoCommand());
        commands.put("schlafen", new SleepCommand());
        commands.put("zurueck", new BackCommand());
        commands.put("benutze", new UseCommand());
        commands.put("info", new InfoCommand());
        commands.put("hilfe", new HelpCommand(this));
        commands.put("ende", new QuitCommand());
    }

    /**
     * Liefere für ein gegebenes Kommandowort das dazugehörige Command-Objekt
     * Rückgabe ist <null>, wenn ein nicht existierendes Kommandowort eingegeben wurde.
     */
    public Command get(String word)
    {
        // Wenn word kein gültiges Kommandowort ist, wird in der HashMap commands nichts gefunden.
        // In diesem Falle liefere ein NullCommand-Objekt zurück.
        if(commands.get(word) == null) {
            return new NullCommand();
        }
        // Andernfalls liefere das passende Command-Objekt zurück.
        else {
            return commands.get(word);

        }
    }

    public static HashMap<String, Command> getCommands() {
        return commands;
    }
    /**
     * Gib eine Liste aller existierenden Kommandos auf System.out aus.
     */
    public void showAll()
    {
        for (String s : commands.keySet()) {
            PrintUtil.showMessage(s + "  ");
        }
        System.out.println();
    }
}
