import java.util.ArrayList;
import java.util.List;

public class SurveyUserInputs
{
	private List<String> userInput = new ArrayList<String>();

	public void setInputs(List<String> ansStrings)
	{
		for (String string : ansStrings)
		{
			userInput.add(string);
		}

	}

	public List<String> getInputs()
	{
		return userInput;

	}
}
