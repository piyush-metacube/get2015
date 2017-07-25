package OOPQuestion1;

public class Matrix
{

	private int data[][];
	private int nRows;
	private int nCols;

	// constructor
	public Matrix(int row, int col)
	{
		nRows = row;
		nCols = col;
		data = new int[nRows][nCols];
	}

	// method to updating data
	public void addElement(int[][] dt)
	{
		data = dt;
	}

	// method to get elements of matrix
	public int[][] getMatrix()
	{
		return data;
	}

	// method to transpose the matrix
	public Matrix tanspose()
	{
		int[][] array = new int[nCols][nRows];
		for (int i = 0; i < nRows; i++)
		{
			for (int j = 0; j < nCols; j++)
			{
				array[j][i] = data[i][j];
			}
		}
		data = new int[nCols][nRows];
		data = array;
		return this;
	}

}
