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
		System.out.println("cool intro that explains setup and stuff yeah");
	}

}
