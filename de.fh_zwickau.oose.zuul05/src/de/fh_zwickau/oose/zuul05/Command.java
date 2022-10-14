package de.fh_zwickau.oose.zuul05;
/**
 * Diese Klassen enthält Informationen über ein vom Spieler eingegebenes Kommando.
 * Ein Kommando besteht aus zwei Strings: einem Kommandowort (commandWord)
 * und einem zweiten Wort (secondWord).
 * 
 * Wenn beispielsweise das Kommando "nimm keule" eingegeben wurde, ist
 * commandWord "nimm" und secondWord "keule"
 * 
 * Es wird überprüft, ob ein Command-Objekt ein gültiges Kommando enthält.
 * Wenn der Spieler ein ungültiges Kommandowort eingegeben hat, dann hat
 * commandWord den Wert <null>. 
 *
 * Besteht das Kommando aus nur einem Wort, hat secondWord den Wert <null>.
 * 
 * @author  Michael Kolling and David J. Barnes
 */

public class Command
{
    private String commandWord;
    private String secondWord;

    /**
     * Konstruktor: Erzeuge ein Command-Objekt.
     * Die Argumente sind das erste und das zweite Wort des Kommandos,
     * jedes davon (oder beide) können <null> sein.
     * @param firstWord Das erste Wort des Kommandos.
     *                  (<null>, wenn kein gültiges Kommandowort erkannt wurde)
     * @param secondWord Das zweite Wort des Kommandos.
     */
    public Command(String firstWord, String secondWord)
    {
        commandWord = firstWord;
        this.secondWord = secondWord;
    }

    /**
     * @return Das Kommandowort.
     */
    public String getCommandWord()
    {
        return commandWord;
    }

    /**
     * @return Das zweite Wort des Kommandos (Rückgabe ist <null>, wenn kein zweites Wort eingegeben wurde).
     */
    public String getSecondWord()
    {
        return secondWord;
    }

    /**
     * @return true wenn kein gültiges Kommando erkannt wurde.
     */
    public boolean isUnknown()
    {
        return (commandWord == null);
    }

    /**
     * @return true wenn das Kommando ein zweites Wort hat.
     */
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
}

