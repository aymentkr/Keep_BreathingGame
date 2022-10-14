package de.fh_zwickau.oose.zuul05;
/**
 * Diese Klasse enthält eine Enumeration aller im Spiel bekannten Kommandowörter.
 * Sie wird genutzt, um eingegebene Kommandos zu erkennen.
 *
 * @author  Michael Kolling and David J. Barnes
 */

public class CommandWords
{
    // ein konstantes Feld, das alle gültigen Kommandowörter enthält
    private static final String[] validCommands = {
        "gehe", "ende", "hilfe"
    };

    /**
     * Konstruktor - Kommandowörter initialisieren
     */
    public CommandWords()
    {
        // derzeit nix zu tun
    }

    /**
     * Testet, ob ein String ein gültiges Kommandowort ist
     * @return true wenn der String ein gültiges Kommandowort ist,
     * false wenn das nicht der Fall ist.
     */
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        // Wenn das Programm an diese Stelle gelangt, ist  aString kein gültiges Kommandowort.
        return false;
    }
}
