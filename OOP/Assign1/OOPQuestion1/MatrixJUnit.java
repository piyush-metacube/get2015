package OOPQuestion1;

import org.junit.Assert;
import org.junit.Test;

public class MatrixJUnit
{

	@Test
	public void test()
	{
		int row = 3, col = 2;
		Matrix mat = new Matrix(row, col);

		int[][] array = { { 2, 3 }, { 4, 5 }, { 7, 8 } };
		mat.addElement(array);
		mat.tanspose();
		int[][] outputArray = mat.getMatrix();
		int[][] expTArray = { { 2, 4, 7 }, { 3, 5, 8 } };

		Assert.assertEquals("Not matched", 1, isArrayEqual(expTArray, outputArray, col, row));

	}

	static int isArrayEqual(int expected[][], int output[][], int row, int col)
	{
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				if (expected[i][j] != output[i][j]) return 0;
		return 1;
	}

}
