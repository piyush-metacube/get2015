import java.util.ArrayList;
import java.util.List;

//this class will hold user inputs
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
