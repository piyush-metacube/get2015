import java.util.ArrayList;
import java.util.List;

public class Day4Assignment
{
	final int NUMBER_OF_COLUMNS = 4; // for matrix of 4X4 for N Queen Problem
	List<String> towerStrings = new ArrayList<String>();

	// function to check for TOwer of Hanoi solution
	public List<String> towerOfHanoi(String source, String destination, String temp, int numOfDisk)
	{
		if (numOfDisk > 1)
		{
			// Move top n-1 disks from source to destination, using temp as auxiliary
			towerOfHanoi(source, temp, destination, numOfDisk - 1);
			// Move remaining disks from source to temp
			towerStrings.add("Move Disk " + numOfDisk + " from " + source + " to " + destination);
			// Move n-1 disks from destination to temp using source as auxiliary
			towerOfHanoi(temp, destination, source, numOfDisk - 1);
		}
		else // If only 1 disk, make the move and return
		if (numOfDisk == 1)
		{
			towerStrings.add("Move Disk " + numOfDisk + " from " + source + " to " + destination);
			return towerStrings;
		}
		return towerStrings;
	}

	// function to check for permutation solution
	public List<String> generatePermutations(String input, String str)
	{
		List<String> permutations = new ArrayList<>();
		int n = str.length();
		if (n == 0)
			permutations.add(input);
		else
			for (int i = 0; i < n; i++)
				permutations.addAll(generatePermutations(input + str.charAt(i), str.substring(i + 1, n) + str.substring(0, i)));
		return permutations;
	}

	// below function will be used for N queen problem
	// function to print solution
	void printSolution(int board[][])
	{
		for (int i = 0; i < NUMBER_OF_COLUMNS; i++)
		{
			for (int j = 0; j < NUMBER_OF_COLUMNS; j++)
				System.out.print(board[i][j]);
			System.out.println();
		}
	}

	// function to check if a queen can be placed on board[row][col]
	boolean isSafe(int board[][], int row, int col)
	{
		int i, j;

		// Check this row on left side
		for (i = 0; i < col; i++)
			if (board[row][i] == 1) return false;

		// Check upper diagonal on left side
		for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
			if (board[i][j] == 1) return false;

		// Check lower diagonal on left side
		for (i = row, j = col; j >= 0 && i < NUMBER_OF_COLUMNS; i++, j--)
			if (board[i][j] == 1) return false;

		return true;
	}

	/* A recursive utility function to solve N Queen problem */
	boolean nQueen(int board[][], int col)
	{
		// base case: If all queens are placed then return true
		if (col >= NUMBER_OF_COLUMNS) return true;

		// Consider this column and try placing this queen in all rows one by one
		for (int i = 0; i < NUMBER_OF_COLUMNS; i++)
			if (isSafe(board, i, col) == true) // Check if queen can be placed on board[i][col]
			{
				board[i][col] = 1;// Place this queen in board[i][col]

				if (nQueen(board, col + 1) == true) return true; // recur to place rest of the queens

				board[i][col] = 0; // BACKTRACK incase If placing queen in board[i][col] doesn't lead to a solution then remove queen from
									// board[i][col]
			}

		return false;// If queen can not be place in any row in this colum col then return false
	}

}
