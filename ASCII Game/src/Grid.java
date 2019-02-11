import java.util.Random;

public class Grid {
	private int width = 1;
	private int height = 1;
	
	private Tile[][] grid;
	
	private Random random;
	
	public Grid(int width, int height)
	{
		this.width = width;
		this.height = height;
		this.random = new Random();
		
		// initialize grid
		initGrid();
	}
	
	public void initGrid()
	{
		grid = new Tile[height][width];
		
		for (int i = 0; i < height; i++) // loop through rows
		{
			for (int j = 0; j < width; j++) // loop through columns
			{
				grid[i][j] = new Tile(i, j, Tile.State.EMPTY);
			}
		}
	}
	
	public void randomize()
	{
		for (int i = 0; i < height; i++) // loop through rows
		{
			for (int j = 0; j < width; j++) // loop through columns
			{
				int rand = 1 + (int)(Math.random() * ((7) + 1));
				System.out.println(rand);
				if (rand > Tile.State.values().length - 1) rand = 2; // make blank tiles more likely
				grid[i][j] = new Tile(i, j, Tile.State.values()[rand]);
			}
		}
	}
	
	/** Returns the tile at the given row and column */
	public Tile getTile(int row, int col)
	{
		return grid[row][col];
	}
	
	public void draw()
	{
		for (int i = 0; i < height; i++) // loop through rows
		{
			for (int j = 0; j < width; j++) // loop through columns
			{
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

}
