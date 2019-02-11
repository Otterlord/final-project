
public class Entity {
	private int row;
	private int col;
	
	private Grid grid;
	
	public Player(Grid grid, int row, int col)
	{
		this.grid = grid;
		grid.getTile(row, col).setState(Tile.State.EMPTY); // clear space for player
		teleportToTile(row, col);
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
	
	public void teleportToTile(int row, int col)
	{
		// in case we need to revert
		int tempRow = this.row;
		int tempCol = this.col;
		
		try
		{
			if (grid.getTile(row, col).isSolid()) throw new SolidTileException(); // you can't move onto solid tiles
			
			grid.getTile(this.row, this.col).setState(Tile.State.EMPTY);
			this.row = row;
			this.col = col;
			grid.getTile(row, col).setState(Tile.State.PLAYER);
		
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			// undo movements
			grid.getTile(tempRow, tempCol).setState(Tile.State.PLAYER);
			this.row = tempRow;
			this.col = tempCol;
			
			System.out.println("You can't move out of bounds.");
			grid.draw();
			System.out.println("Enter new move: ");
			move();
		}
		catch (SolidTileException s)
		{
			System.out.println("You can't move onto solid tiles!");
			move();
			
		}
	}
	
	public String getInput()
	{
		String input = Game.scanner.next();
		
		if (input.equals("w") || input.equals("a") || input.equals("s") || input.equals("d")) return input;
		System.out.println("Invalid input.");
		return getInput();
	}
	
}

}
