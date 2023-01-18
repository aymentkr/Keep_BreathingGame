package de.fh_zwickau.oose.zuul05.model.commands;

import static org.junit.jupiter.api.Assertions.*;

import de.fh_zwickau.oose.zuul05.model.Commands.CommandWords;
import de.fh_zwickau.oose.zuul05.model.Commands.HelpCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.fh_zwickau.oose.zuul05.model.*;

class HelpCommandTest {
    public Player player;
    public HelpCommand helpCommand;
    public CommandWords commandWords;

    @BeforeEach
    void init() {

        this.commandWords=new CommandWords();
        this.helpCommand=new  HelpCommand(commandWords);
        player=new Player();



    }
    @Test
    void testHelpCommandWithCommandGehe() {

        helpCommand.setSecondWord("gehe");



        assertEquals("""
			    Beweg in einen anderen Raum
			    Es gibt viele Möglichkeiten, sich durch Tippen von Raum zu Raum zu bewegen
			    wie folgt: - gehe links
			               - gehe recht
			               - gehe unten
			               - gehe oben
			    """, helpCommand.getCommandWord());


    }
    @Test
    void testHelpCommandWithXYZCommand() {


        helpCommand.setSecondWord("");



        assertEquals("Das ist kein gültiges Kommando!", helpCommand.getCommandWord());

    }
    @Test
    void testHelpCommandWithCommandSchlafen() {

        helpCommand.setSecondWord("schlafen");


        assertEquals("Ruhe dich aus und mach dich bereit für den nächsten Tag", helpCommand.getCommandWord());


    }
    @Test
    void testHelpCommandWithCommandZurueck() {

        helpCommand.setSecondWord("zurueck");


        assertEquals("Gehe mal zurueck", helpCommand.getCommandWord());


    }
    @Test
    void testHelpCommandWithCommandHilfe() {

        helpCommand.setSecondWord("hilfe");


        assertEquals("sehe alle möglichen Kommandos", helpCommand.getCommandWord());


    }
    @Test
    void testHelpCommandWithCommandEnde() {

        helpCommand.setSecondWord("ende");


        assertEquals("das Spiel verlassen", helpCommand.getCommandWord());


    }


}


