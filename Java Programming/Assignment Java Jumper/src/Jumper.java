
/**
 * Description: Jumper Class is the Main Program for the Jave Jumper Assignment.
 * The Jumper Class is where the Main method runs and where the Player will interact with the Game.
 * @author Tristan Sim
 * @version 1.01
 * @
 */

import java.util.Scanner; 

public class Jumper 
{
    // Fields
    private Player player;
    private Map map; 
    private int turn;

    /**
     * Default Constructor
     */
    public Jumper()
    {
        this.player = new Player();
        this.map = new Map(); 
        this.turn = 0; 
    }






    /**
     * Main Method: This is the Main Method of the Jumper Class & the Java Jumper Assignment
     */
    public static void main(String[] args)
    {
        Jumper javaJumper = new Jumper(); 

        javaJumper.map.initializeMap(0);

        System.out.println(javaJumper.player.displayPlayer());
        System.out.println(javaJumper.map.displayMap());
    }

}