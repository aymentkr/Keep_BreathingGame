package de.fh_zwickau.oose.zuul05.Game;
/**
 * Implementierung des Kommandos "gehe"
 * 
 * @author Michael Kolling
 * @version 1.0 (December 2002)
 */
public class GoCommand extends Command
{
    /**
     * Konstruktor.
     */
    public GoCommand()
    {
    }

    /** 
     * 
     * Versuche, in eine Richtung zu laufen. Wenn es dort einen Ausgang
     * gibt, betritt den betreffenden Raum. Andernfalls wird eine Fehlermeldung
     * ausgegeben.
     * 
     * @return immer false.
     */
       
    public boolean execute(Player player)
    {
        if(hasSecondWord()) {
            String direction = getSecondWord();
            player.walk(direction);
        }
        else {
        	 // Wenn kein zweites Wort eingegeben wurde, haben wir keine Ahnung, wohin der Spieler gehen will:
            System.out.println("WOHIN gehen?");
        }
        return false;
    }
}
