package de.fh_zwickau.oose.zuul05;

import java.util.Scanner;

/**
 * Dieser Parser liest die Eingaben des Spielers und versucht, sie als Kommando
 * für das Adventure-Spiel zu interpretieren.
 * Jedesmal, wenn er aufgerufen wird, liest er eine Eingabezeile und versucht,
 * diese Eingabe als Kommando, bestehend aus ein oder zwei Wörtern, zu
 *  interpretieren. Das Kommando wird dann als Objekt der Command-Klasse
 *  zurückgeliefert.
 * 
 * Der Parser greift auf eine Menge bekannter Kommandowörter zu.
 * Die Eingaben des Benutzers werden mit dieser Liste verglichen. Wenn die Eingabe
 * keinem gültigen Kommandowort entspricht, wird ein Command-Objekt zurückgeliefert,
 * dessen Kommandowort <null> ist.
 *
 * @author  Michael Kolling and David J. Barnes
 */
public class Parser 
{
    private CommandWords commands;  // enthält alle erlaubten Kommandowörter
    private Scanner reader;         // die Quelle der Eingaben

    /**
     * Erzueuge den Parser und lies eine per Tastatur eingegebene Zeile.
     */
    public Parser() 
    {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    /**
     * @return Das auszuführende Kommando als Command-Objekt.
     */
    public Command getCommand() 
    {
        String inputLine;   // In dieser Variablen wird die vom Spieler eingegebene Zeile stehen.
        String word1 = null;
        String word2 = null;

        System.out.print("> ");     // Zeichen ">" als Eingabeaufforderung ausgeben

        inputLine = reader.nextLine();

        // Lies bis zu zwei Wörter ein
        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();          // erstes eingegebenes Wort (Kommandowort)
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();      // zweites eingegebenes Wort
                // Eventuell weitere folgende Wörter werden ignoriert.
            }
        }
       
        // Jetzt wird getestet, ob das erste Wort ein bekanntes Kommandowort ist.
        // Falls ja, wird ein entsprechendes Command-Objekt erzeugt.
        // Falls nein, wird ein Command-Objekt mit <null>-Parameter erzeugt.
        if(commands.isCommand(word1)) {
            return new Command(word1, word2);
        }
        else {
            return new Command(null, word2); 
        }
    }
}
