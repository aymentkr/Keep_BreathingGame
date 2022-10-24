package de.fh_zwickau.oose.zuul05.Game;
/**
 * Implementatiierung des Kommandos "hilfe"
 * 
 * @author Michael Kolling
 */
public class HelpCommand extends Command
{
    private CommandWords commandWords;
    
    /**
     * Konstruktor  
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
        System.out.println("Du bist alleine und verloren und lungerst");
        System.out.println("in der Hochschule rum.");
        System.out.println();
        System.out.println("Mögliche Kommandos sind:");
        commandWords.showAll();
        return false;
    }
}
