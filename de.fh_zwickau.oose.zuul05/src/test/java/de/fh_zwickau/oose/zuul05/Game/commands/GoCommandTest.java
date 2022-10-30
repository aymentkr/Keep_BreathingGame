package de.fh_zwickau.oose.zuul05.Game.commands;




import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.fh_zwickau.oose.zuul05.Game.Game;

class GoCommandTest {
	
	public Game game;
	public GoCommand goCommand;
	@BeforeEach
	void init() {
		this.game=new Game();
		this.goCommand=new GoCommand();

	
		
		
	}
	
	@Test
	void testStartRoom() {
		assertEquals("im Ruheraum", game.getPlayer().getCurrentRoom().getShortDescription());
		
	}
	@Test
	void testGoCommandGetDescription() {
		assertEquals("""
			    Beweg in einen anderen Raum
			    Es gibt viele Möglichkeiten, sich durch Tippen von Raum zu Raum zu bewegen
			    wie folgt: - gehe links
			               - gehe recht
			               - gehe unten
			               - gehe oben
			    """, goCommand.getDescription());
		
	}
	
	@Test
	void testGoCommandSetSecondWordAndEcecute() {	
	goCommand.setSecondWord("unten");
	goCommand.execute(game.getPlayer());
	
	assertEquals("Platz der Kategorie Essen", game.getPlayer().getCurrentRoom().getShortDescription());
	
	}
	@Test
	void testGoCommandFromEssenraumToGetraenkraum() {
		goCommand.setSecondWord("unten");
		goCommand.execute(game.getPlayer());
		goCommand.setSecondWord("links");
		goCommand.execute(game.getPlayer());
		
		assertEquals("Platz der Kategorie Getraenke", game.getPlayer().getCurrentRoom().getShortDescription());
		
	}
	@Test
	void testGoCommandFromGetraenkraumToObstraum() {
		goCommand.setSecondWord("unten");
		goCommand.execute(game.getPlayer());
		goCommand.setSecondWord("links");
		goCommand.execute(game.getPlayer());
		goCommand.setSecondWord("links");
		goCommand.execute(game.getPlayer());

		
		assertEquals("Platz der Kategorie Obst", game.getPlayer().getCurrentRoom().getShortDescription());
		
	}

	@Test
	void testGoCommandFromObstraumToSchiffsdach() {
		goCommand.setSecondWord("unten");
		goCommand.execute(game.getPlayer());
		goCommand.setSecondWord("links");
		goCommand.execute(game.getPlayer());
		goCommand.setSecondWord("links");
		goCommand.execute(game.getPlayer());
		goCommand.setSecondWord("oben");
		goCommand.execute(game.getPlayer());

		
		assertEquals("in der Schiff Oberfläche", game.getPlayer().getCurrentRoom().getShortDescription());
		
	}
	
	@Test
	void testGoCommandFromschiffsdachToschlaffraum() {
		goCommand.setSecondWord("unten");
		goCommand.execute(game.getPlayer());
		goCommand.setSecondWord("links");
		goCommand.execute(game.getPlayer());
		goCommand.setSecondWord("links");
		goCommand.execute(game.getPlayer());
		goCommand.setSecondWord("oben");
		goCommand.execute(game.getPlayer());
		goCommand.setSecondWord("recht");
		goCommand.execute(game.getPlayer());
		
		assertEquals("im Ruheraum", game.getPlayer().getCurrentRoom().getShortDescription());
		
	}



}

