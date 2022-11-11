package de.fh_zwickau.oose.zuul05.model.commands;

import de.fh_zwickau.oose.zuul05.model.Commands.BackCommand;
import de.fh_zwickau.oose.zuul05.model.Commands.GoCommand;
import de.fh_zwickau.oose.zuul05.model.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.testng.AssertJUnit.assertEquals;


class BackCommandTest {

    public static Player player;
    public static BackCommand backCommand;
    public static GoCommand goCommand ;

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
        backCommand = new BackCommand();
        goCommand=new GoCommand();
        player=new Player();
    }
    @Test
    void testBackCommandGetDescription() {
        assertEquals("Gehe mal zurueck", backCommand.getDescription());
    }

    @Test
    void testBackCommandWithOutPrecedentRoom() {

        player.setCurrentRoom(schiffsdach);
        backCommand.execute(player);
        assertEquals("in der Schiff Oberfläche", player.getCurrentRoom().getShortDescription());


    }
    @Test
    void testBackCommandWithPrecedentRoom() {

        player.setCurrentRoom(schiffsdach);
        goCommand.setSecondWord("recht");
        goCommand.execute(player);
        assertEquals("im Ruheraum", player.getCurrentRoom().getShortDescription());

        backCommand.execute(player);
        assertEquals("in der Schiff Oberfläche", player.getCurrentRoom().getShortDescription());


    }

}
