package de.fh_zwickau.oose.zuul05.model.commands;

import de.fh_zwickau.oose.zuul05.model.Commands.SleepCommand;
import de.fh_zwickau.oose.zuul05.model.Commands.UseCommand;
import de.fh_zwickau.oose.zuul05.model.Game;
import de.fh_zwickau.oose.zuul05.model.Items.*;
import de.fh_zwickau.oose.zuul05.model.Player;
import de.fh_zwickau.oose.zuul05.model.Room;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UseCommandTest {

    public static UseCommand useCommand;

    public static Player player;
    public static Room obstraum;
    public static Room essenraum;
    public static Room schiffsdach;
    public static Room schlaffraum;
    public static Room getraenkraum;
    public static SleepCommand sleepCommand;
    public static Game game;


    @BeforeAll
    static void  setStruktur(){
        //creat rooms with Items
        obstraum = new Room("Platz der Kategorie Obst");
        obstraum.addItem(new FruitItem("orange",""));
        obstraum.addItem(new FruitItem("apfel",""));


        essenraum = new Room("Platz der Kategorie Essen");
        essenraum.addItem(new FoodItem("döner",""));


        schiffsdach = new Room("in der Schiff Oberfläche");
        schiffsdach.addItem(new MasteryBox("masterybox","Solve the quiz to get the key"));

        schlaffraum=new Room("im Ruheraum");

        getraenkraum=new Room("Platz der Kategorie Getraenke");
        getraenkraum.addItem(new DrinkItem("saft",""));


        //add exits for rooms
        obstraum.setExit("oben", schiffsdach);
        obstraum.setExit("recht", getraenkraum);

        essenraum.setExit("links", getraenkraum);

        schiffsdach.setExit("unten",obstraum);
        schiffsdach.setExit("recht",schlaffraum);

        schlaffraum.setExit("unten",essenraum);
        schlaffraum.setExit("links",schiffsdach);

        getraenkraum.setExit("links",obstraum);
        getraenkraum.setExit("recht",essenraum);

    }

    @BeforeEach
    void setUp() {

        useCommand=new UseCommand();
        sleepCommand=new SleepCommand();
        player=new Player();
        game=new Game();

    }

    @Test
    void testAddAndRemoveItemsFromRoom() {

        player.setCurrentRoom(obstraum);
        player.walk("recht");

        assertEquals("saft",getraenkraum.getItems().get(0).getName());

        player.setCurrentRoom(getraenkraum);
        essenraum.setGeschlossen(false);
        player.walk("recht");

        assertEquals("döner",essenraum.getItems().get(0).getName());


    }

    @Test
    void testUseCommandWithIncreasingHealth() {

        player.setHealth(10);
        player.setCurrentRoom(getraenkraum);
        player.walk("links");
        useCommand.setSecondWord("orange");
        useCommand.execute(player);

        assertEquals("orange",obstraum.getItems().get(0).getName());
        assertEquals(25,player.getHealth());

    }

    @Test
    void testSleepCommandWithReducingHealth() {



        player.setHealth(75);
        player.setCurrentRoom(getraenkraum);
        player.walk("links");
        useCommand.setSecondWord("apfel");
        useCommand.execute(player);
        player.walk("oben");
        player.walk("recht");
        sleepCommand.execute(player);


        assertEquals("im Ruheraum",player.getCurrentRoom().getShortDescription());

        assertEquals(15,player.getHealth());

}
}