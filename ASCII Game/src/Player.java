public class Player extends Entity{
	
	public Player(Grid grid, int row, int col)
	{
		super(grid, row, col);
	}
	
	public void move()
	{
		grid.draw();
		String input = getInput();

		if (input.equals("w")) teleportToTile(row - 1, col);
		if (input.equals("s")) teleportToTile(row + 1, col);
		if (input.equals("d")) teleportToTile(row, col + 1);
		if (input.equals("a")) teleportToTile(row, col - 1);
	
		
	}
	
	public String getInput()
	{
		String input = Game.scanner.next();
		
		if (input.equals("w") || input.equals("a") || input.equals("s") || input.equals("d")) return input;
		System.out.println("Invalid input.");
		return getInput();
	}
	
}
