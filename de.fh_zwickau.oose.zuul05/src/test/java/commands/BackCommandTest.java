package commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.fh_zwickau.oose.zuul05.Game.Player;
import de.fh_zwickau.oose.zuul05.Game.Room;
import de.fh_zwickau.oose.zuul05.Game.commands.BackCommand;
import de.fh_zwickau.oose.zuul05.Game.commands.GoCommand;

class BackCommandTest {

   private final String ESSENZIMMER ="essenZimmer";
   private final String SCHLAFFZIMMER = "schlaffzimmer";
   private final String OBSTZIMMER = "obstZimmer";
   private final String WASSERZIMMER="wasserZimmer";
   private final String BACK = "zurück";
  // private final String GO = "gehe";
   private final String GOHOME = "gehe zum schlaff zimmer";	

   public Player player;
	public BackCommand backComand;
	public GoCommand goCommand;
	public Room essenZimmer;
	public Room schlaffZimmer;
	public Room obstZimmer;
	public Room wasserZimmer;
	@BeforeEach
	void init() {
		this.player=new Player();
		this.backComand=new BackCommand();
		this.goCommand=new GoCommand();
		this.essenZimmer=new Room(ESSENZIMMER);
		this.schlaffZimmer=new Room(SCHLAFFZIMMER);
		this.obstZimmer=new Room(OBSTZIMMER);
		this.wasserZimmer=new Room(WASSERZIMMER);
		
		//obstZimmer.setExit(SCHLAFFZIMMER, schlaffZimmer);
		obstZimmer.setExit(BACK, wasserZimmer);
		obstZimmer.setExit(GOHOME, schlaffZimmer);
		
		//wasserZimmer.setExit(OBSTZIMMER, obstZimmer);
		wasserZimmer.setExit(BACK, essenZimmer);
		wasserZimmer.setExit(GOHOME, schlaffZimmer);
		
		//essenZimmer.setExit(GO, wasserZimmer);
				essenZimmer.setExit(BACK, schlaffZimmer);
				essenZimmer.setExit(GOHOME, schlaffZimmer);
				//schlaffZimmer.setExit(GO, essenZimmer);
				
				
			}
			
			
			@Test
			void testBackCommandGetDescription() {	
				assertEquals("Gehe in den Schlafraum", backComand.getDescription());
			
			}


}