public class Tile {
	private int row;
	private int col;
	
	private State state;
	
	public static enum State {
		PLAYER, ENEMY, EMPTY, WALL
	}

	
	public Tile(int row, int col, State state)
	{
		this.row = row;
		this.col = col;

		this.setState(state);
	}

	public void setState(State state)
	{
		this.state = state;
	}
	
	public boolean isSolid()
	{
		if (state == state.EMPTY) return false;
		return true;
	}
	
	public String toString()
	{
		if (state == state.PLAYER) return "Ü";
		else if (state == state.ENEMY) return "X";
		else if (state == state.EMPTY) return "-";
		else if (state == state.WALL) return "W";
		else return "Invalid state";
	}
}