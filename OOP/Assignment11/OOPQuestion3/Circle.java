package OOPQuestion3;

public class Circle implements Shape
{
	private int radius;
	final double PI_VALUE = 3.14;

	public Circle(int radius)
	{
		this.radius = radius;
	}

	public void draw()
	{
		System.out.println("Function To Draw Circle");
	}

	public double getArea()
	{
		return PI_VALUE * (radius * radius);

	}

}
