package de.fh_zwickau.oose.zuul05.model.commands;

import de.fh_zwickau.oose.zuul05.model.Commands.BackCommand;
import de.fh_zwickau.oose.zuul05.model.Commands.GoCommand;
import de.fh_zwickau.oose.zuul05.model.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.testng.AssertJUnit.assertEquals;


class BackCommandTest {

    public  Player player;
    public  BackCommand backCommand;
    public  GoCommand goCommand ;

    public static Room schlaffraum;
    public static Room essenraum;
    public static Room schiffsdach;
    public static Room getraenkraum;
    public static Room obstraum;

    @BeforeAll
    static void  setStruktur(){
        //creat rooms
        obstraum=new Room("in obstRaum");
        schlaffraum = new Room("im Ruheraum");
        essenraum = new Room("Platz der Kategorie Essen");
        essenraum.setGeschlossen(true);
        schiffsdach = new Room("in der Schiff Oberfläche");
        getraenkraum=new Room("in Getraenk Raum");
        //add exits for rooms
        schlaffraum.setExit("unten", essenraum);
        schlaffraum.setExit("links", schiffsdach);

        essenraum.setExit("links", getraenkraum);
        essenraum.setExit("oben", schlaffraum);

        schiffsdach.setExit("recht",schlaffraum);
        schiffsdach.setExit("unten",obstraum);

        obstraum.setExit("oben",schiffsdach);
        obstraum.setExit("recht",getraenkraum);

        getraenkraum.setExit("recht",essenraum);
        getraenkraum.setExit("links",obstraum);

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

    @Test
    void testBackCommandWithLastRoomInBoatStruktur(){
        player.setCurrentRoom(schlaffraum);
        goCommand.setSecondWord("links");
        goCommand.execute(player);
        goCommand.setSecondWord("unten");
        goCommand.execute(player);
        goCommand.setSecondWord("recht");
        goCommand.execute(player);
        essenraum.setGeschlossen(false);
        goCommand.setSecondWord("recht");
        goCommand.execute(player);

      assertEquals("Platz der Kategorie Essen", player.getCurrentRoom().getShortDescription());

        backCommand.execute(player);
        assertEquals("in Getraenk Raum", player.getCurrentRoom().getShortDescription());
        backCommand.execute(player);
        assertEquals("in obstRaum", player.getCurrentRoom().getShortDescription());
        backCommand.execute(player);
        assertEquals("in der Schiff Oberfläche", player.getCurrentRoom().getShortDescription());
        backCommand.execute(player);
        assertEquals("im Ruheraum", player.getCurrentRoom().getShortDescription());




    }

}
