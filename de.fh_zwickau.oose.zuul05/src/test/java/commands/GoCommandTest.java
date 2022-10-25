package commands;

import static org.junit.jupiter.api.Assertions.*;

import de.fh_zwickau.oose.zuul05.Game.Player;
import de.fh_zwickau.oose.zuul05.Game.Room;
import de.fh_zwickau.oose.zuul05.Game.commands.GoCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The type Go command test.
 */
class GoCommandTest {

    private final String SCHLAFFZIMMER = "schlaffzimmer";
    private final String OBSTZIMMER = "obstzimmer";


    /**
     * The Player.
     */
    public Player player;
    /**
     * The Go command.
     */
    public GoCommand goCommand;
    /**
     * The Schlaffzimmer.
     */
    public Room schlaffzimmer;
    /**
     * The Obstzimmer.
     */
    public Room obstzimmer;
    private final String BACK = "zurück";

    /**
     * Init.
     */
    @BeforeEach
    void init() {
        this.player = new Player();
        this.goCommand = new GoCommand();
        this.schlaffzimmer = new Room(SCHLAFFZIMMER);
        this.obstzimmer = new Room(OBSTZIMMER);
        schlaffzimmer.setExit(OBSTZIMMER,obstzimmer);
        player.setCurrentRoom(schlaffzimmer);
    }

    /**
     * Test return walk from beginning.
     */
    @Test
    void testReturnWalkFromBeginning() {
        goCommand.setSecondWord(BACK);
        goCommand.execute(player);
        assertEquals(schlaffzimmer, player.getCurrentRoom().getShortDescription());
    }

    /**
     * Test return walk after one walk.
     */
    @Test
    void testReturnWalkAfterOneWalk() {
        goCommand.setSecondWord(SCHLAFFZIMMER);
        goCommand.execute(player);
        goCommand.setSecondWord(BACK);
        goCommand.execute(player);
        assertEquals(obstzimmer, player.getCurrentRoom().getShortDescription());
    }

    /**
     * Test return walk two times.
     */
    @Test
    void testReturnWalkTwoTimes() {
        goCommand.setSecondWord(SCHLAFFZIMMER);
        goCommand.execute(player);
        goCommand.setSecondWord(OBSTZIMMER);
        goCommand.execute(player);
        goCommand.setSecondWord(BACK);
        goCommand.execute(player);
        goCommand.setSecondWord(BACK);
        goCommand.execute(player);
        assertEquals(obstzimmer, player.getCurrentRoom().getShortDescription());
    }

    /**
     * Test walk one time.
     */
    @Test
    void testWalkOneTime() {
        goCommand.setSecondWord(OBSTZIMMER);
        goCommand.execute(player);
        assertEquals(obstzimmer, player.getCurrentRoom().getShortDescription());
    }

    /**
     * Test walk two times.
     */
    @Test
    void testWalkTwoTimes() {
        goCommand.setSecondWord(SCHLAFFZIMMER);
        goCommand.execute(player);
        goCommand.setSecondWord(OBSTZIMMER);
        goCommand.execute(player);
        assertEquals(obstzimmer, player.getCurrentRoom().getShortDescription());
    }

}
