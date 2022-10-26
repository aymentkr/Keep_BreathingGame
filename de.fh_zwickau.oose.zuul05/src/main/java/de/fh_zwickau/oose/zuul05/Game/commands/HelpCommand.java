package de.fh_zwickau.oose.zuul05.Game.commands;

import de.fh_zwickau.oose.zuul05.Game.Player;

/**
 * Implementatiierung des Kommandos "hilfe"
 *
 * @author Michael Kolling
 */
public class HelpCommand extends Command
{
    private final CommandWords commandWords;

    /**
     * Konstruktor
     *
     * @param words eine Instanz der Klasse CommandWords.
     */
    public HelpCommand(CommandWords words)
    {
        commandWords = words; // Dadurch weiß die HelpCommand-Klasse,
                              // welche Kommandos es gibt.
    }
    
    /**
     * Gib einen kurzen Hilfetext und alle gültigen Kommandoworte aus.
     * @return immer false.
     */
    public boolean execute(Player player)
    {
        System.out.println("""
                Du bist einsam, verloren und hungrig
                In einem verlorenen Schiff
                Alle um dich herum sind gestorben
                
                Mögliche Kommandos sind:
                """
        );
        for (String name: CommandWords.getCommands().keySet()) {
            String key = name.toString();
            String value = CommandWords.getCommands().get(name).getDescription();
            System.out.println(key + " :  " + value);
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "sehe alle möglichen Kommandos";
    }
}
