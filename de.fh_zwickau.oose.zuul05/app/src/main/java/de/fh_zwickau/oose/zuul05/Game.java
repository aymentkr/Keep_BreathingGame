package de.fh_zwickau.oose.zuul05;

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

public class Game 
{
    private Parser parser;
    private Room currentRoom;
        
    /**
     * Konstruktor der Game-Klasse, legt auch die Raumstruktur fest.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Erzeugt alle Räume und die Verbindungen zwischen ihnen.
     */
    private void createRooms()
    {
        Room draussen, hoersaal, mensa, computerraum, adminraum;
      
        // Räume erzeugen
        draussen = new Room("vor dem Haupteingang der Hochschule");
        hoersaal = new Room("in einem Hörsaal");
        mensa = new Room("in der Mensa");
        computerraum = new Room("in einem Computerraum");
        adminraum = new Room("im Raum des Computer-Admins");
        
        // Ausgänge initialisieren
        draussen.setExits(null, hoersaal, computerraum, mensa);
        hoersaal.setExits(null, null, null, draussen);
        mensa.setExits(null, draussen, null, null);
        computerraum.setExits(draussen, adminraum, null, null);
        adminraum.setExits(null, null, null, computerraum);

        currentRoom = draussen;  // Das Spiel startet draußen!
    }
    
    /**
     * Die main-Methode instanziiert eine neue Game-Klasse und startet das Spiel.
     */
    public static void main(String[] args) {
    	Game game = new Game();
    	game.play();
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
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
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
        System.out.println("Du bist: " + currentRoom.getDescription());
        System.out.print("Die Ausgänge: ");
        if(currentRoom.northExit != null) {
            System.out.print("Norden ");
        }
        if(currentRoom.eastExit != null) {
            System.out.print("Osten ");
        }
        if(currentRoom.southExit != null) {
            System.out.print("Süden ");
        }
        if(currentRoom.westExit != null) {
            System.out.print("Westen ");
        }
        System.out.println();
    }

    /**
     * Wurde ein Kommando-Objekt übergeben, so führe das passende Kommando aus.
     * @param command Das auszuführende Kommando.
     * @return true Wenn das Spiel beendet wurde, andernfalls false.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("Ich verstehe nicht, was Du meinst...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("hilfe"))
            printHelp();
        else if (commandWord.equals("gehe"))
            goRoom(command);
        else if (commandWord.equals("ende"))
            wantToQuit = quit(command);

        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Gib einen kurzen Hilfetext und alle gültigen Kommandoworte aus.
     * 
     */
    private void printHelp() 
    {
        System.out.println("Du bist alleine und verloren und lungerst");
        System.out.println("in der Hochschule rum.");
        System.out.println();
        System.out.println("Mögliche Kommandos sind:");
        System.out.println("   gehe ende hilfe");
    }

    /** 
     * "Gehe" wurde eingegeben.
     * Versuche, in eine Richtung zu laufen. Wenn es dort einen Ausgang
     * gibt, betritt den betreffenden Raum. Andernfalls wird eine Fehlermeldung
     * ausgegeben.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // Wenn kein zweites Wort eingegeben wurde, haben wir keine Ahnung, wohin der Spieler gehen will:
            System.out.println("WOHIN gehen?");
            return;
        }

        String direction = command.getSecondWord();

        // Versuche, den aktuellen Raum zu verlassen:
        Room nextRoom = null;
        if(direction.equals("norden")) {
            nextRoom = currentRoom.northExit;
        }
        if(direction.equals("osten")) {
            nextRoom = currentRoom.eastExit;
        }
        if(direction.equals("süden")) {
            nextRoom = currentRoom.southExit;
        }
        if(direction.equals("westen")) {
            nextRoom = currentRoom.westExit;
        }

        if (nextRoom == null) {
            System.out.println("Da ist keine Tür!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println("Du bist: " + currentRoom.getDescription());
            System.out.print("Die Ausgänge: ");
            if(currentRoom.northExit != null) {
                System.out.print("Norden ");
            }
            if(currentRoom.eastExit != null) {
                System.out.print("Osten ");
            }
            if(currentRoom.southExit != null) {
                System.out.print("Süden ");
            }
            if(currentRoom.westExit != null) {
                System.out.print("Westen ");
            }
            System.out.println();
        }
    }

    /** 
     * "Ende" wurde eingegeben.
     * Daraufhin wird "true" zurückgegeben, worauf das Spiel beendet wird.
     */
    private boolean quit(Command command) 
    {
            return true;  // zeigt an, dass das Spiel beendet werden soll
        
    }
}
