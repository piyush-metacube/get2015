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

		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				mat.addElement(i, j, i * j);
			}
		}
		mat.show();
		mat.tanspose();
		int[][] outputArray = mat.getMatrix();
		int[][] expTArray = { { 0, 0, 0 }, { 0, 1, 2 } };

		Assert.assertEquals("Not matched", 1, isArrayEqual(expTArray, outputArray));

	}

	static int isArrayEqual(int expected[][], int output[][])
	{
		for (int i = 0; i < expected.length; i++)
			for (int j = 0; j < expected[i].length; j++)
				if (expected[i][j] != output[i][j]) return 0;
		return 1;
	}

}
