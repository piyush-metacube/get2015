import java.util.List;

public class Day4ProgramMain
{

	/**
	 * @param args
	 */
	public static void main(String args[])
	{
		Day4Assignment assign = new Day4Assignment();
		// Tower of hanoi
		for (String string : assign.towerOfHanoi("A", "C", "B", 1))
			System.out.println(string);

		// permutation check
		List<String> perms = assign.generatePermutations("", "ABCD");

		String[] array = new String[perms.size()];
		for (int i = 0; i < perms.size(); i++)
			array[i] = perms.get(i);

		for (final String anArray : array)
			System.out.println(anArray);
		// N queen problem
		int[][] board = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		if (assign.nQueen(board, 0) == false)
			System.out.println("Solution does not exist");
		else
			assign.printSolution(board);
	}
}
