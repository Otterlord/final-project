
public class Enemy extends Entity {
	
	private Vector2 moveDir;

	public Enemy(Grid grid, int row, int col) {
		super(grid, row, col, Tile.State.ENEMY);
		moveDir = new Vector2(0, 1);
		this.speed = 0;
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

}
