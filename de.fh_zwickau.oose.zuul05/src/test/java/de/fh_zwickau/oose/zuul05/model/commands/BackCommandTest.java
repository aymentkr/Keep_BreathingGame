package de.fh_zwickau.oose.zuul05.model.commands;

import de.fh_zwickau.oose.zuul05.model.Commands.BackCommand;
import de.fh_zwickau.oose.zuul05.model.Commands.GoCommand;
import de.fh_zwickau.oose.zuul05.model.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.testng.AssertJUnit.assertEquals;


class BackCommandTest {

    public Game game;
    public BackCommand backCommand;
    public GoCommand goCommand;
    @BeforeEach
    void init() {
        game=new Game();
        this.backCommand=new BackCommand();
        this.goCommand=new GoCommand();
    }
    @Test
    void testBackCommandGetDescription() {
        assertEquals("Gehe mal zurueck", backCommand.getDescription());
    }

    @Test
    void testBackCommandFromEssenraumToSchlaffraum() {
        goCommand.setSecondWord("unten");
        goCommand.execute(game.getPlayer());
        assertEquals("Platz der Kategorie Essen", game.getPlayer().getCurrentRoom().getShortDescription());

        backCommand.execute(game.getPlayer());
        assertEquals("im Ruheraum", game.getPlayer().getCurrentRoom().getShortDescription());

    }
    @Test
    void testBackCommandFromSchlaffraumToSchiffsdach() {
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

        backCommand.execute(game.getPlayer());

        assertEquals("in der Schiff Oberfläche", game.getPlayer().getCurrentRoom().getShortDescription());

    }
    @Test
    void testBackCommandFromSchiffsdachToObstraum() {
        goCommand.setSecondWord("unten");
        goCommand.execute(game.getPlayer());
        goCommand.setSecondWord("links");
        goCommand.execute(game.getPlayer());
        goCommand.setSecondWord("links");
        goCommand.execute(game.getPlayer());
        goCommand.setSecondWord("oben");
        goCommand.execute(game.getPlayer());


        assertEquals("in der Schiff Oberfläche", game.getPlayer().getCurrentRoom().getShortDescription());

        backCommand.execute(game.getPlayer());

        assertEquals("Platz der Kategorie Obst", game.getPlayer().getCurrentRoom().getShortDescription());

    }
    @Test
    void testBackCommandFromObstraumToGetraenkraum() {
        goCommand.setSecondWord("unten");
        goCommand.execute(game.getPlayer());
        goCommand.setSecondWord("links");
        goCommand.execute(game.getPlayer());
        goCommand.setSecondWord("links");
        goCommand.execute(game.getPlayer());



        assertEquals("Platz der Kategorie Obst", game.getPlayer().getCurrentRoom().getShortDescription());

        backCommand.execute(game.getPlayer());

        assertEquals("Platz der Kategorie Getraenke", game.getPlayer().getCurrentRoom().getShortDescription());

    }
    @Test
    void testBackCommandFromGetraenkraumToEssenraum() {
        goCommand.setSecondWord("unten");
        goCommand.execute(game.getPlayer());
        goCommand.setSecondWord("links");
        goCommand.execute(game.getPlayer());




        assertEquals("Platz der Kategorie Getraenke", game.getPlayer().getCurrentRoom().getShortDescription());

        backCommand.execute(game.getPlayer());

        assertEquals("Platz der Kategorie Essen", game.getPlayer().getCurrentRoom().getShortDescription());

    }



}
