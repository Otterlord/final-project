public abstract class Entity {
	protected int row;
	protected int col;
	
	protected Grid grid;
	private Tile.State myState;
	
	public Entity(Grid grid, int row, int col, Tile.State state)
	{
		this.myState = state;
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
			grid.getTile(row, col).setState(myState);
		
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			// undo movements
			grid.getTile(tempRow, tempCol).setState(myState);
			this.row = tempRow;
			this.col = tempCol;
			
			handleWall();
		}
		catch (SolidTileException s)
		{
			handleWall();
			
		}
	}

}
