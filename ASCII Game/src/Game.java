import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Game {
	public static Scanner scanner;
	public static Random random;
	
	public static boolean playerDead = false;
	public static ArrayList<Entity> entities; // holds all the entities other than the player
	
	public static void main(String[] args)
	{
		init();
		printIntro();
		
		gameLoop();
		System.out.println("Player surrounded!!!");
	}

	// Main game loop
	private static void gameLoop()
	{
		// Initialize stuff
		
		Grid grid = new Grid(8, 8);
		grid.randomize();
		entities.add(new Player(grid, 3, 3));
		//entities.add(new Enemy(grid, 2, 2));
		
		
		while (!playerDead)
		{
			
			Collections.sort(entities); // sort based on speed
			for (Entity e : entities)
			{
				System.out.println(e);
				e.doTurn();
			}
			
		}
	}
	
	private static void init()
	{
		scanner = new Scanner(System.in);
		random = new Random();
		entities = new ArrayList<Entity>();
	}
	
	private static void printIntro()
	{
		System.out.println("Epic story goes here");
		System.out.println("Once upons a tim, there wasl a good crab namesd Darren");
		System.out.println("'well it sure is nice today yes my freid,' said darren");
		System.out.println("suddnely, a big sexplosions happend and everyone diead");
		System.out.println("'this sucsk, fudge u' sedc darren, adn hesd vowed to get revenge on the guy who planed the bomb");
		System.out.println("howed er, b4 daren culd win and stuffs, he ded");
		System.out.println("3nter u");
	}

}
