package de.fh_zwickau.oose.zuul05.commands;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.fh_zwickau.oose.zuul05.Game;

class GoCommandTest {

    public Game game;
    public GoCommand goCommand;

    @BeforeEach
    void init() {
        this.game = new Game();
        this.goCommand = new GoCommand();

    }
    @Test
    void testStartRoom() {
        assertEquals("im Ruheraum", game.getPlayer().getCurrentRoom().getShortDescription());

    }

}