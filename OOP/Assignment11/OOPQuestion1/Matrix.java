package OOPQuestion1;

public class Matrix
{

	private int data[][];
	private int noRows;
	private int noCols;

	// constructor
	public Matrix(int row, int col)
	{
		noRows = row;
		noCols = col;
		data = new int[noRows][noCols];
	}

	// method to updating data
	public void addElement(int row, int col, int value)
	{
		data[row][col] = value;
	}

	// method to get elements of matrix
	public int[][] getMatrix()
	{
		return data;
	}

	public void show()
	{
		for (int i = 0; i < data.length; i++)
		{
			for (int j = 0; j < data[i].length; j++)
			{
				System.out.print(" " + data[i][j]);
			}
			System.out.println();

		}
	}

	// method to transpose the matrix
	public Matrix tanspose()
	{
		int[][] array = new int[noCols][noRows];
		for (int i = 0; i < noRows; i++)
		{
			for (int j = 0; j < noCols; j++)
			{
				array[j][i] = data[i][j];
			}
		}
		data = new int[noCols][noRows];
		data = array;
		return this;
	}

}
