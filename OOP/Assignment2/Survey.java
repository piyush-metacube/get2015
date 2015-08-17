import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

//this class will contain userinputs and list of questions and it will be used for generating reports
public class Survey
{
	private SurveyQuestionList questionList;
	private List<SurveyUserInputs> usersDataInputs;

	public Survey()
	{
		questionList = new SurveyQuestionList();
		usersDataInputs = new ArrayList<SurveyUserInputs>();
	}

	public List<String> getQuestions()
	{
		return questionList.questions;
	}

	public List<String> getOptionType()
	{
		return questionList.questionTypeList;
	}

	public List<String> getOptions()
	{
		return questionList.questionOption;
	}

	public void setUserInput(List<String> userAns)
	{
		SurveyUserInputs inputs = new SurveyUserInputs();
		inputs.setInputs(userAns);
		usersDataInputs.add(inputs);
	}

	public List<SurveyUserInputs> getUserData()
	{
		return usersDataInputs;
	}

	// will generate % of inputs
	public double getReport(int option)
	{
		++option;
		int total = usersDataInputs.size();
		int opt = 0;

		for (SurveyUserInputs surveyUserInputs : usersDataInputs)
		{
			String r = surveyUserInputs.getInputs().get(0);
			opt += Integer.parseInt(r) == option ? 1 : 0; // calculating occrance in whole student input list
		}
		float percen = ((float) opt / total) * 100;

		return roundTwoDecimals(percen);
	}

	double roundTwoDecimals(double d)
	{
		DecimalFormat twoDForm = new DecimalFormat("#.##");
		return Double.valueOf(twoDForm.format(d));
	}
}
