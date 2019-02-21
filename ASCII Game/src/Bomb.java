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
		
		grid.getTile(coords.add(Vector2.up)).setState(Tile.State.EMPTY);
		grid.getTile(coords.add(Vector2.down)).setState(Tile.State.EMPTY);
		grid.getTile(coords.add(Vector2.right)).setState(Tile.State.EMPTY);
		grid.getTile(coords.add(Vector2.left)).setState(Tile.State.EMPTY);
	}
	
	private void explodeTile(Vector2 coords)
	{
		Tile tile = grid.getTile(coords);
		if (tile.getState() == Tile.State.WALL || tile.getState() == Tile.State.ENEMY)
		{
			tile.setState(Tile.State.EMPTY);
			grid.draw();
		}
		if (tile.getState() == Tile.State.PLAYER)
		{
			System.out.println("You were killed in the explosion");
			grid.draw();
			Game.killPlayer();
		}
	}

}
