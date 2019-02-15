import java.util.Scanner;

public class Game {
	public static Scanner scanner;
	
	public static void main(String[] args)
	{
		init();
		printIntro();
		
		gameLoop();
	}
	
	// Main game loop
	private static void gameLoop()
	{
		// Initialize stuff
		boolean cleared = false;
		boolean dead = false;
		
		Grid grid = new Grid(8, 8);
		grid.randomize();
		Player player = new Player(grid, 3, 3);
		Enemy enemy = new Enemy(grid, 2, 2);
		
		while (!cleared && !dead)
		{
			enemy.doTurn();
			player.doTurn();
			
		}
	}
	
	private static void init()
	{
		scanner = new Scanner(System.in);
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
