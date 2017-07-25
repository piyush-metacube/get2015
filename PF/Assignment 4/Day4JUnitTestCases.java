import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class Day4JUnitTestCases
{
	Day4Assignment assign = new Day4Assignment();
	List<String> towerStrings = new ArrayList<String>();

	@Test
	public void checkTowerOfHanoi()
	{
		List<String> resList = assign.towerOfHanoi("A", "C", "B", 1);
		List<String> expList = new ArrayList<String>();
		expList.add("Move Disk 1 from A to C");

		Assert.assertEquals(expList, resList);
	}

	@Test
	public void checkTowerOfHanoi1()
	{
		List<String> resList = assign.towerOfHanoi("A", "C", "B", 2);
		List<String> expList = new ArrayList<String>();
		expList.add("Move Disk 1 from A to B");
		expList.add("Move Disk 2 from A to C");
		expList.add("Move Disk 1 from B to C");
		Assert.assertEquals(expList, resList);
	}

	@Test
	public void checkTowerOfHanoi2()
	{
		List<String> resList = assign.towerOfHanoi("A", "C", "B", 3);
		List<String> expList = new ArrayList<String>();
		expList.add("Move Disk 1 from A to C");
		expList.add("Move Disk 2 from A to B");
		expList.add("Move Disk 1 from C to B");
		expList.add("Move Disk 3 from A to C");
		expList.add("Move Disk 1 from B to A");
		expList.add("Move Disk 2 from B to C");
		expList.add("Move Disk 1 from A to C");

		Assert.assertEquals(expList, resList);
	}

	@Test
	public void checkForPermutation()
	{
		List<String> resList = assign.generatePermutations("", "ABC");

		List<String> expList = new ArrayList<String>();

		expList.add("ABC");
		expList.add("ACB");
		expList.add("BCA");
		expList.add("BAC");
		expList.add("CAB");
		expList.add("CBA");

		Assert.assertEquals(expList, resList);

	}

	@Test
	public void checkForPermutation1()
	{
		List<String> resList = assign.generatePermutations("", "ABCD");
		List<String> expList = new ArrayList<String>();

		expList.add("ABCD");
		expList.add("ABDC");
		expList.add("ACDB");
		expList.add("ACBD");
		expList.add("ADBC");
		expList.add("ADCB");
		expList.add("BCDA");
		expList.add("BCAD");
		expList.add("BDAC");
		expList.add("BDCA");
		expList.add("BACD");
		expList.add("BADC");
		expList.add("CDAB");
		expList.add("CDBA");
		expList.add("CABD");
		expList.add("CADB");
		expList.add("CBDA");
		expList.add("CBAD");
		expList.add("DABC");
		expList.add("DACB");
		expList.add("DBCA");
		expList.add("DBAC");
		expList.add("DCAB");
		expList.add("DCBA");
		Assert.assertEquals(expList, resList);
	}

	@Test
	public void CheckForNQueen()
	{
		int[][] board = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		int[][] exResponse = new int[][] { { 0, 0, 1, 0 }, { 1, 0, 0, 0 }, { 0, 0, 0, 1 }, { 0, 1, 0, 0 } };
		boolean NqueenResponse = assign.nQueen(board, 0);
		if (NqueenResponse) // if true then check for processed matrix
			Assert.assertEquals(1, isArrayEqual(board, exResponse));
		else
			fail("No solution Found");

	}

	static int isArrayEqual(int expected[][], int output[][])
	{
		int result = 1;
		int row = expected.length;
		for (int i = 0; i < row; i++)
			for (int j = 0; j < 4; j++)
				if (expected[i][j] != output[i][j])
				{
					result = 0;
					break;
				}

		return result;
	}
}
