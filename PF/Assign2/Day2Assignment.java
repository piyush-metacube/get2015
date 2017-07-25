public class Day2Assignment
{

	final String NP = "NP";
	final String Error_NEGATIVE_NUMBER = "Number cant be negative";
	final String Error_ZERO_NUMBER = "Number cant be Zero";
	final String error_ONE_DIGIT = "Number should be a single digit number";

	// MEthod is printing RIght angle triangle and
	// noOfrows are numbers of rows which will be printed
	public String[] printPyramid(int noOfRows)
	{
		// checking for valid integer value
		String[] err = checkForError(noOfRows);
		if (!err[0].equals("NP")) return err;

		String[] pyStrings = new String[noOfRows]; // array to be returned
		for (int i = 0; i < noOfRows; i++)
			pyStrings[i] = spaces(i + 1, noOfRows) + numbers(i + 1, noOfRows); // Decomposition--
																				// getting
																				// spaces
																				// and
																				// number
																				// seperately
		return pyStrings;
	}

	public String[] checkForError(int n)
	{
		String[] errorMessage = new String[] { "NP" };

		if (n < 0)
		{
			errorMessage[0] = Error_NEGATIVE_NUMBER;
			return errorMessage;
		}
		else if (n == 0)
		{
			errorMessage[0] = Error_ZERO_NUMBER;
			return errorMessage;
		}
		else if (n > 9)
		{
			errorMessage[0] = error_ONE_DIGIT;
			return errorMessage;
		}
		return errorMessage;
	}

	public String spaces(int row, int n)
	{
		String spc = "";
		for (int i = n - row + 1; i < n; i++)
			spc += " ";
		return spc;
	}

	public String numbers(int row, int n)
	{
		String num = "";
		for (int i = 0; i < n - row + 1; i++)
			num += String.valueOf(i + 1);
		return num;

	}
}
