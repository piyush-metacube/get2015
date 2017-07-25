import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day1Assignment
{
	int convertBinaryToOctal(int n)
	{
		int count = 0, octal = 0;
		while (n != 0)
		{
			int sum = 0;
			for (int i = 0; i < 3; i++)
			{
				if (n == 0) break;
				int remainder = n % 10;
				n /= 10;
				sum += remainder * (int) Math.pow(2, i);
			}
			octal += sum * (int) Math.pow(10, count);
			count++;
		}
		return octal;
	}

	public int[] removeDuplicate(int input[])
	{

		List<Integer> processedList = new ArrayList<Integer>();
		List<Integer> intList = new ArrayList<Integer>();

		for (int value : input)
			intList.add(value);

		for (Integer intL : intList)
		{
			boolean flag = false;
			for (Integer intP : processedList)
				if (intP == intL)
				{
					flag = true;
					break;
				}
			if (flag == false) processedList.add(intL);

		}
		int[] ret = new int[processedList.size()];
		int ii = 0;
		for (Integer e : processedList)
			ret[ii++] = e.intValue();

		return ret;
	}

	public int isSorted(int[] a)
	{
		int flag = 0, tCount = 0;
		for (int i = 0; i < a.length - 1; i++)
		{

			if (a[i] < a[i + 1])
			{
				flag = 1;
				tCount++;
			}
			else
			{
				flag = 0;
				break;
			}
		}
		if (flag == 1)
			return 1;
		else if (tCount > 0)
			return 0;
		else
		{
			for (int i = 0; i < a.length - 1; i++)
			{

				if (a[i] > a[i + 1])
					flag = 1;
				else
				{
					flag = 0;
					break;
				}
			}
			if (flag == 1)
				return 2;
			else
				return 0;
		}

	}

	public int[][] FCFS(int arrival_time[], int job_size[], int n)
	{
		final int NO_OF_COLUMNS = 5;
		int[] jWaitTime = new int[n];
		int[] jStartAt = new int[n];
		int[] jFInishedAt = new int[n];
		int[][] result = new int[n][NO_OF_COLUMNS];
		jWaitTime[0] = 0;
		jStartAt[0] = 1;
		for (int i = 0; i < n - 1; i++)
		{
			jFInishedAt[i] = jStartAt[i] + job_size[i] - 1;
			if (arrival_time[i + 1] < jFInishedAt[i])
			{
				jStartAt[i + 1] = jFInishedAt[i] + 1;
				jWaitTime[i + 1] = jStartAt[i + 1] - arrival_time[i + 1];
			}
			else
			{
				jWaitTime[i + 1] = 0;
				jStartAt[i + 1] = arrival_time[i + 1];
			}

		}
		jFInishedAt[n - 1] = jStartAt[n - 1] + job_size[n - 1] - 1;
		for (int i = 0; i < n; i++)
		{
			int k = 0;
			result[i][k++] = i + 1;
			result[i][k++] = arrival_time[i];
			result[i][k++] = jWaitTime[i];
			result[i][k++] = jStartAt[i];
			result[i][k++] = jFInishedAt[i];
		}

		return result;
	}

	public int[] join(int[] a, int asize, int[] b, int bsize, int[] c)
	{

		int i = 0, j = 0, k = 0;

		while (i < asize && j < bsize)
			if (a[i] < b[j])
				c[k++] = a[i++];

			else
				c[k++] = b[j++];

		while (i < asize)
			c[k++] = a[i++];

		while (j < bsize)
			c[k++] = b[j++];

		return c;
	}

	public int[] longestSequence(int input[])
	{
		int seqLength = 0, sIndex = 0, lIndex = 0, sIndexN = 0, lIndexN = 0, maxSeqLength = 0;
		List<Integer> seq = new List<Integer>();
		int[] longestArray;

		for (int i = 0; i < input.length - 1; i++)
		{
			if (input[i] < input[i + 1] && (i + 1) != input.length - 1)
			{
				seq.add(input[i]);
				lIndexN = i;
				seqLength++;

			}
			else
			{
				if ((i + 1) == input.length - 1)
				{

					seq.add(input[i]);
					lIndexN = i;
					seqLength++;
				}

				seq.clear();
				if (maxSeqLength < seqLength)
				{
					maxSeqLength = seqLength;
					sIndex = sIndexN;
					lIndex = lIndexN;
				}
				seqLength = 0;
				sIndexN = i + 1;

			}
		}

		longestArray = new int[lIndex - sIndex + 2];
		int t = sIndex;
		for (int i = 0; i < (lIndex - sIndex + 2); i++)
			longestArray[i] = input[t++];

		return longestArray;
	}

}
