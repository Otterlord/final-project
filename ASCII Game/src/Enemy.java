
public class Enemy extends Entity {
	
	private Vector2 moveDir;

	public Enemy(Grid grid, int row, int col) {
		super(grid, row, col, Tile.State.ENEMY);
	}

	@Override
	public void doTurn() {
		move(-moveDir.y, moveDir.x);
	}

	@Override
	public void handleWall() {
		moveDir = new Vector2(-moveDir.x, -moveDir.y);
		
	}

	
	
	

}
