
public class Enemy extends Entity {
	
	private Vector2 moveDir;

	public Enemy(Grid grid, int row, int col) {
		super(grid, row, col, Tile.State.ENEMY);
		moveDir = new Vector2(1, 0);
	}

	@Override
	public void doTurn() {
		move(moveDir.y, moveDir.x);
	}

	@Override
	public void handleWall(Vector2 wallDir) {
		moveDir = new Vector2(wallDir.x, wallDir.y);
		//System.out.println("wallDir" + wallDir);
		//System.out.println("new movedir" + moveDir);
		if (surrounded(moveDir) && surrounded(new Vector2(moveDir.y, moveDir.x))) return;
		else if (surrounded(moveDir)) moveDir = new Vector2(moveDir.y, moveDir.x);
		doTurn();
		
	}

	// Returns true if both sides are blocked
	private boolean surrounded(Vector2 dir) {
		try
		{
			return (grid.getTile(coords.add(dir)).isSolid() && grid.getTile(coords.add(dir.reversed())).isSolid()); // return true if both sides are solid
		}
		catch (ArrayIndexOutOfBoundsException a) // if out of bounds, then we are definitely surrounded
		{
			return true;
		}
	}

}
