
public class Enemy extends Entity {
	

	public Enemy(Grid grid, int row, int col) {
		super(grid, row, col);
		
		myState = Tile.State.ENEMY;
	}

	@Override
	public void doTurn() {
		move(-1, 0);
	}

	@Override
	public void handleWall() {
		// TODO Auto-generated method stub
		
	}

	
	
	

}
