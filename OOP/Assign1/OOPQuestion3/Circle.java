package OOPQuestion3;

public class Circle implements Shape
{
	private int radius;

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
		return (22 / 7) * (radius * radius);

	}

}
