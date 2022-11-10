package de.fh_zwickau.oose.zuul05.model.commands;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.fh_zwickau.oose.zuul05.model.*;
import de.fh_zwickau.oose.zuul05.model.Commands.GoCommand;

class GoCommandTest {

    public static Player player;
    public static GoCommand goCommand;
    public static Room schlaffraum;
    public static Room essenraum;
    public static Room schiffsdach;
    public static Room getraenkraum;

    @BeforeAll
    static void  setStruktur(){
        //creat rooms
        schlaffraum = new Room("im Ruheraum");
        essenraum = new Room("Platz der Kategorie Essen");
        essenraum.setGeschlossen(true);
        schiffsdach = new Room("in der Schiff Oberfläche");
        //add exits for rooms
        schlaffraum.setExit("unten", essenraum);
        schlaffraum.setExit("links", schiffsdach);

        essenraum.setExit("links", getraenkraum);
        essenraum.setExit("oben", schlaffraum);

        schiffsdach.setExit("recht",schlaffraum);


    }
    @BeforeEach
    void init() {

        goCommand = new GoCommand();
        player=new Player();



    }
    @Test
    void testStartRoom() {
        player.setCurrentRoom(schlaffraum);
        assertEquals("im Ruheraum", player.getCurrentRoom().getShortDescription());

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
        player.setCurrentRoom(schiffsdach);

        goCommand.setSecondWord("recht");
        goCommand.execute(player);

        assertEquals("im Ruheraum", player.getCurrentRoom().getShortDescription());

    }
    @Test
    void testIfEssenRaumLockedIs() {
        player.setCurrentRoom(schlaffraum);

        goCommand.setSecondWord("unten");
        goCommand.execute(player);

        assertEquals("im Ruheraum",player.getCurrentRoom().getShortDescription());
        assertTrue(essenraum.isGeschlossen());

        goCommand.setSecondWord("links");
        goCommand.execute(player);

        assertEquals("in der Schiff Oberfläche", player.getCurrentRoom().getShortDescription());

    }


}


