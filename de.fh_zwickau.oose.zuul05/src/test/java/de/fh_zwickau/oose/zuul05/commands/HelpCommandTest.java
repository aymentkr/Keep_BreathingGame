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



    }}
