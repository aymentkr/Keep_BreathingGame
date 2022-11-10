package de.fh_zwickau.oose.zuul05.model.Commands;

import de.fh_zwickau.oose.zuul05.model.Player;
import de.fh_zwickau.oose.zuul05.utils.PrintUtil;


/**
 * Ein Objekt der Klasse NullCommand wird erzeugt, wenn ein ungültiges
 * Kommando eingegeben wurde.
 * Das NullCommand tut bei seiner Ausführung nichts weiter, als eine Fehlermeldung auszugeben. 
 *
 * @author Michael Kolling
 */
public class NullCommand extends Command
{

    /**
     * Konstruktor.
     */
    public NullCommand()
    {

    }

    /**
     * Gibt eine Fehlermeldung aus.
     * @return immer false.
     */
    public boolean execute(Player player)
    {
        PrintUtil.showMessage("Ich verstehe nicht, was Du meinst... Gib \"hilfe\" ein, um eine Liste der gültigen Kommandos zu sehen.");
        return false;
    }

    @Override
    public String getDescription() {
        return "Das ist kein gültiges Kommando!";
    }
}
