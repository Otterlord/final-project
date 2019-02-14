public class Vector2 {
	public int x;
	public int y;
	
	public Vector2(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public String toString()
	{
		return "(" + x + ", " + y + ")";
	}
	
	public Vector2 add(Vector2 what)
	{
		return new Vector2(this.x + what.x, this.y + what.y);
	}
	
	public Vector2 reversed()
	{
		return new Vector2(this.x * -1, this.y * -1);
	}

}
