package OOPQuestion3;

public class Square implements Shape
{
	private int side;

	public Square(int side)
	{
		this.side = side;
	}

	public void draw()
	{
		System.out.print("Function To Draw Square");
	}

	public double getArea()
	{
		return (side * side);
	}

}
