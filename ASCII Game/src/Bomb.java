 public class Bomb extends Entity {
	private int timer = 5;

	public Bomb(Grid grid, int row, int col) {
		super(grid, row, col, Tile.State.BOMB);
		this.speed = 2; // will update before other entities
	}

	@Override
	public void doTurn() {
		if (timer == 0) explode();
		System.out.println("Bomb: " + timer + "TURNS LEFT");
		timer--;
	}

	@Override
	public void handleWall(Vector2 dir) {
		// we don't need this method
	}
	
	private void explode()
	{
		System.out.println("в00м!!!!");
		this.destroy();
	}

}
