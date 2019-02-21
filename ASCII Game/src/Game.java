import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Game {
	public static Scanner scanner;
	public static Random random;
	
	private static boolean playerDead = false;
	private static boolean sort = false;
	public static ArrayList<Entity> entities; // holds all the entities other than the player
	
	private static Grid grid;
	private static ArrayList<Entity> removeQueue;
	
	public static void main(String[] args)
	{
		init();
		printIntro();
		
		gameLoop();
		System.out.println("Player surrounded!!!");
	}
	
	// Flags that we should re-sort entities this turn
	public static void updateEntities()
	{
		sort = true;
	}
	
	public static void killPlayer()
	{
		playerDead = true;
	}

	// Main game loop
	private static void gameLoop()
	{
		// Initialize stuff
		
		grid = new Grid(8, 8);
		grid.randomize();
		entities.add(new Player(grid, 3, 3));
		entities.add(new Enemy(grid, 2, 2));
		entities.add(new Bomb(grid, 3, 2));
		
		sortEntities();
		
		while (!playerDead)
		{
			// Clear the queue so we won't remove things that have already been removed
			removeQueue.clear();

			for (Entity e : entities)
			{
				e.doTurn();
				if (playerDead) return;
				if (sort) sortEntities();
				sort = false; // reset sort
			}
		
			entities.removeAll(removeQueue);
			
		}
	}
	
	// Adds the given entity to remove queue -- so it will be removed at the end of the turn
	public static void destroyEntity(Entity e)
	{
		//entities.remove(e);
		removeQueue.add(e);
		grid.getTile(e.coords).setState(Tile.State.EMPTY);
		
	}
	
	// Sorts the entities arraylist based on speed
	public static void sortEntities()
	{
		Collections.sort(entities); // sort based on speed
	}
	
	private static void init()
	{
		scanner = new Scanner(System.in);
		random = new Random();
		entities = new ArrayList<Entity>();
		removeQueue = new ArrayList<Entity>();
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
		System.out.println();
		System.out.println("------------------------------------------------------------------");
		System.out.println("INSTRUCTIONS");
		System.out.println("w = up, s = down, d = right, a = left");
		System.out.println("B = bomb, W = wall, O = enemy, - = blank tile, Ü = you");
		System.out.print("\n\n");
	}

}
