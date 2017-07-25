package OOPQuestion3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OOPQuestion3JUnit
{

	@Test
	public void test()
	{
		Shape obj = new Square(5);
		double expected = 25.0;
		double actual = obj.getArea();
		assertEquals(expected, actual, 0);
	}

	@Test
	public void test1()
	{
		Shape obj = new Circle(5);
		double expected = 75.0;
		double actual = obj.getArea();
		assertEquals(expected, actual, 0);
	}

}
