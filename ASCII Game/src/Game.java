import java.util.Random;
import java.util.Scanner;

public class Game {
	public static Scanner scanner;
	public static Random random;
	
	public static boolean playerDead = false;
	
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
		Player player = new Player(grid, 3, 3);
		Enemy enemy = new Enemy(grid, 2, 2);
		Enemy sec = new Enemy(grid, 2, 3);
		
		while (!playerDead)
		{
			player.doTurn();
			if (playerDead) return; // if player dies after their turn, quit
			enemy.doTurn();
			sec.doTurn();
			//player.doTurn();
			
		}
	}
	
	private static void init()
	{
		scanner = new Scanner(System.in);
		random = new Random();
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
