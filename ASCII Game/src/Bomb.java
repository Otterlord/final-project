 

public class Bomb extends Entity {
	

	public Bomb(Grid grid, int row, int col) {
		super(grid, row, col, Tile.State.BOMB);
	}

	@Override
	public void doTurn() {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleWall(Vector2 dir) {
		// we don't need this method
	}
	
	private void expode()
	{
		this.destroy();
	}

}
