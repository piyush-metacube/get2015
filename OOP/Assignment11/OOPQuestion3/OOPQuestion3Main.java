package OOPQuestion3;

import java.util.Scanner;

public class OOPQuestion3Main
{

	static void printShape(Shape shape)
	{
		System.out.println("Area is : " + shape.getArea());
	}

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Program to calculate area");
		System.out.println("Enter the value of radius");
		Shape shape = new Circle(sc.nextInt());							// Take the radius input
		shape.draw();
		shape.getArea();
		printShape(shape);
		System.out.println("Enter the value of side to find the area");// Take the side input
		Shape squareobj = new Square(sc.nextInt());
		squareobj.draw();
		squareobj.getArea();
		printShape(squareobj);
		sc.close();
	}

}
