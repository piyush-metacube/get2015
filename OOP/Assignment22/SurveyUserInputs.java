import java.util.ArrayList;
import java.util.List;

//this class will hold user inputs
public class SurveyUserInputs
{
	private List<String> userInputList = new ArrayList<String>();

	public void setInputs(List<String> ansStrings)
	{
		for (String string : ansStrings)
		{
			userInputList.add(string);
		}
	}

	public List<String> getInputs()
	{
		return userInputList;
	}
}
