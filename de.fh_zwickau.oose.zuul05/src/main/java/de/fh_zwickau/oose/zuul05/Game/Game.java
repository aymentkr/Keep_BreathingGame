package de.fh_zwickau.oose.zuul05.Game;
/*
 * 
 * Dies ist die Hauptklasse des Spiels "Die Welt von Zuul"
 * 
 * "Die Welt von Zuul" ist ein einfaches textbasiertes Adventure-Spiel.
 * Der Spieler kann in der Welt herumlaufen.
 * Um das Spiel interessanter zu machen, sollten weitere Kommandos eingebaut werden!
 * 
 * Um das Spiel zu spielen, wird in der main-Methode eine Instanz dieser Klasse
 * erzeugt und die play-Methode aufgerufen.
 * 
 * Diese Klasse sorgt dafür, dass alle nötigen Objekte erzeugt und
 * initialisiert werden: Es werden alle Räume angelegt, der Parser
 * erzeugt und das Spiel gestartet.
 * 
 * In einer Endlosschleife wird dann dafür gesorgt, dass eingegebene Kommandos
 * analysiert und ausgeführt werden.
 * 
 * @author  Michael Kolling and David J. Barnes
 */

class Game 
{
    private final Parser parser;
    private final Player player;

    /**
     * Konstruktor der Game-Klasse, legt auch die Raumstruktur fest.
     */
    public Game() 
    {
        player = new Player();
        parser = new Parser();
        createRooms();
    }
    
    /**
     * Die main-Methode instanziiert eine neue Game-Klasse und startet das Spiel.
     */
    public static void main(String[] args) {
    	Game game = new Game();
    	game.play();
    }

    /**
     * Erzeugt alle Räume und die Verbindungen zwischen ihnen.
     */
    private void createRooms()
    {
        Room draussen, hoersaal, mensa, computerraum, adminraum;
      
        // Räume erzeugen:
        draussen = new Room("vor dem Haupteingang der Hochschule");
        hoersaal = new Room("in einem Hörsaal");
        mensa = new Room("in der Mensa");
        computerraum = new Room("in einem Computerraum");
        adminraum = new Room("im Raum des Computer-Admins");
        
        // Ausgänge aufbauen:
        draussen.setExit("osten", hoersaal);
        draussen.setExit("süden", computerraum);
        draussen.setExit("westen", mensa);

        hoersaal.setExit("westen", draussen);

        mensa.setExit("osten", draussen);

        computerraum.setExit("norden", draussen);
        computerraum.setExit("osten", adminraum);

        adminraum.setExit("westen", computerraum);
        
        // Der Spieler startet das Spiel draußen vor der Hochschule:
        player.setCurrentRoom(draussen);
    }


    /**
     *  Die Hauptroutine des Spiels
     *  Läuft in einer Schleife, bis das Spiel beendet wird.
     */
    public void play() 
    {            
        printWelcome();

        // Hier werden wiederholt Kommando-Eingaben gelesen und die
        // Kommandos ausgeführt, bis das Spiel beendet ist.
                
        boolean finished = false;
        while(! finished) {
            Command command = parser.getCommand();
                finished = command.execute(player);
        }
        System.out.println("Danke fürs Spielen! Schönen Tag noch!");
    }

    /**
     * Gibt die Willkommensnachricht für den Spieler aus.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Willkommen in der Welt von Zuul!");
        System.out.println("Die Welt von Zuul ist ein neues, unglaublich langweiliges Adventure-Spiel.");
        System.out.println("Gib 'hilfe' ein, um Hilfe zu bekommen.");
        System.out.println();
        System.out.println(player.getCurrentRoom().getLongDescription());
    }
}
