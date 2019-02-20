public abstract class Entity implements Comparable<Entity> {
	protected Vector2 coords;
	
	protected Grid grid;
	private Tile.State myState;
	protected int speed; // for the turn order
	
	public Entity(Grid grid, int row, int col, Tile.State state)
	{
		this.myState = state;
		this.grid = grid;
		coords = new Vector2(col, row);
		grid.getTile(row, col).setState(Tile.State.EMPTY); // clear space for entity
		teleportToTile(row, col);
	}
	
	@Override
	public String toString()
	{
		return myState + " of speed: " + speed + " at position " + coords;
	}
	
	// For sorting based on speed
	@Override
	public int compareTo(Entity what)
	{
		return what.speed - speed;
	}
	
	public void move(int rows, int cols)
	{
		teleportToTile(coords.y + rows, coords.x + cols);
	}
	
	public abstract void doTurn();
	
	/** What should be done when we hit a wall? */
	public abstract void handleWall(Vector2 dir);
	
	// Vector2 wrapper
	public void teleportToTile(Vector2 coords)
	{
		teleportToTile(coords.y, coords.x);
	}
	
	// Does what its name says ;)
	public void teleportToTile(int row, int col)
	{
		// in case we need to revert
		int tempRow = this.coords.y;
		int tempCol = this.coords.x;
		
		try
		{
			if (grid.getTile(row, col).isSolid()) throw new SolidTileException(); // you can't move onto solid tiles
			
			grid.getTile(this.coords.y, this.coords.x).setState(Tile.State.EMPTY);
			this.coords.y = row;
			this.coords.x = col;
			grid.getTile(row, col).setState(myState);
		
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			// undo movements
			grid.getTile(tempRow, tempCol).setState(myState);
			this.coords.y = tempRow;
			this.coords.x = tempCol;
			
			Vector2 dir = getHitDirection(new Vector2(col, row));
			
			handleWall(dir);
			
		}
		catch (SolidTileException s)
		{
			Vector2 dir = getHitDirection(new Vector2(col, row));
			
			handleWall(dir);
			
		}
	}
	
	// Returns true if both sides are blocked
	protected boolean solidBlock(Vector2 dir) 
	{
		try
		{
			return (grid.getTile(coords.add(dir)).isSolid()); // return true if solid in current trajectory
		}
		catch (ArrayIndexOutOfBoundsException a) // if out of bounds, then we are definitely surrounded
		{
			return true;
		}
	}
	
	protected boolean surrounded(Vector2 dir)
	{
		return (solidBlock(dir) && solidBlock(dir.reversed()));
	}
	
	// Returns the direction of the wall relative to current position
	private Vector2 getHitDirection(Vector2 wallCoords)
	{
		return new Vector2(coords.x - wallCoords.x, coords.y - wallCoords.y);
	}
	
	protected void destroy()
	{
		System.out.println("Destroying object finish writing htis mehthods");
		grid.getTile(coords).setState(Tile.State.EMPTY); // remove graphical representation of object
		// remove object from list
		
	}

}
