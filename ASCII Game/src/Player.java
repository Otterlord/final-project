public class Player extends Entity	{
	
	public Player(Grid grid, int row, int col)
	{
		super(grid, row, col, Tile.State.PLAYER);
	}
	
	@Override
	public void doTurn()
	{
		grid.draw();
		String input = getInput();

		if (input.equals("w")) move(-1, 0);
		if (input.equals("s")) move(1, 0);
		if (input.equals("d")) move(0, 1);
		if (input.equals("a")) move(0, -1);
	
		
	}
	
	public String getInput()
	{
		String input = Game.scanner.next();
		
		if (input.equals("w") || input.equals("a") || input.equals("s") || input.equals("d")) return input;
		System.out.println("Invalid input.");
		return getInput();
	}

	@Override
	public void handleWall() {
		System.out.println("You can't go through walls or out of bounds!");
		doTurn();
		
	}
	
}
