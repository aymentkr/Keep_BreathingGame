package de.fh_zwickau.oose.zuul05.commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.fh_zwickau.oose.zuul05.Game;

class HelpCommandTest {
    public Game game;
    public HelpCommand helpCommand;
    public CommandWords commandWords;

    @BeforeEach
    void init() {
        this.game=new Game();
        this.commandWords=new CommandWords();
        this.helpCommand=new  HelpCommand(commandWords);



    }
    @Test
    void testHelpCommandWithCommandGehe() {

        helpCommand.setSecondWord("gehe");
        helpCommand.execute(game.getPlayer());


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
    void testHelpCommandWithCommandEssen() {

        helpCommand.setSecondWord("essen");
        helpCommand.execute(game.getPlayer());


        assertEquals("Selbst füttern", helpCommand.getCommandWord());


    }


}
