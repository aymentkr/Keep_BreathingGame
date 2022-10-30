package de.fh_zwickau.oose.zuul05.commands;

import de.fh_zwickau.oose.zuul05.Player;

/**
 * Implementierung des Kommandos "ende"
 * 
 * @author Michael Kolling
 */
public class QuitCommand extends Command
{
    /**
     * Konstruktor.
     */
    public QuitCommand()
    {
    }

    /**
     * "ende" wurde eingegeben.
      * @return immer true (dadurch wird das Spiel beendet).
     * 
     */
    public boolean execute(Player player)
    {
    	return true;
    }

    @Override
    public String getDescription() {
        return "das Spiel verlassen";
    }

}
