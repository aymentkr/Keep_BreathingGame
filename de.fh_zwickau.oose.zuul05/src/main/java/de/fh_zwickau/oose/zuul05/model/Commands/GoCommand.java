package de.fh_zwickau.oose.zuul05.model.Commands;

import de.fh_zwickau.oose.zuul05.model.Player;

/**
 * Implementierung des Kommandos "gehe"
 *
 * @author Michael Kolling
 * @version 1.0 (December 2002)
 */
public class GoCommand extends Command
{

    InfoCommand info =new InfoCommand();
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

    public boolean execute(Player player) {
        if(hasSecondWord()) {
            String direction = getSecondWord();
            player.walk(direction);
            player.infoStuff();
        }
        else {
            // Wenn kein zweites Wort eingegeben wurde, haben wir keine Ahnung, wohin der Spieler gehen will:
            System.out.println("WOHIN gehen?");
        }
        return false;
    }

    @Override
    public String getDescription() {
        return """
    Beweg in einen anderen Raum
    Es gibt viele Möglichkeiten, sich durch Tippen von Raum zu Raum zu bewegen
    wie folgt: - gehe links
               - gehe recht
               - gehe unten
               - gehe oben
    """;
    }
}
