package OOPQuestion1;

import java.util.Scanner;

public class MatrixProgramMain
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int row, col;
		System.out.println("Enter the number of rows and columns of matrix");
		row = sc.nextInt();
		col = sc.nextInt();
		int[][] array = new int[row][col];
		Matrix mat = new Matrix(row, col);

		System.out.println("Enter the elements of matrix");
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				mat.addElement(i, j, sc.nextInt());
			}
		}
		mat.show();
		sc.close();
		mat.tanspose();

		System.out.println("Transposed Matrix is  ");
		mat.show();
	}
}
