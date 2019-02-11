public abstract class Entity {
	protected int row;
	protected int col;
	
	protected Grid grid;
	protected Tile.State myState;
	
	public Entity(Grid grid, int row, int col)
	{
		this.grid = grid;
		grid.getTile(row, col).setState(Tile.State.EMPTY); // clear space for entity
		teleportToTile(row, col);
	}
	
	public void move(int rows, int cols)
	{
		teleportToTile(row + rows, col + cols);
	}
	
	public abstract void doTurn();
	
	/** What should be done when we hit a wall? */
	public abstract void handleWall();
	
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
			handleWall();
		}
		catch (SolidTileException s)
		{
			System.out.println("You can't move onto solid tiles!");
			handleWall();
			
		}
	}

}
