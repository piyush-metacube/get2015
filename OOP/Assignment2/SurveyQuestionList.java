import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//this class will hold all question which are being read from a file
public class SurveyQuestionList
{
	public SurveyQuestionList()
	{
		questions = new ArrayList<String>();
		questionTypeList = new ArrayList<String>();
		questionOption = new ArrayList<String>();
		setupQuestions();
	}

	List<String> questions;
	List<String> questionTypeList;
	List<String> questionOption;

	final String SURVEY_DATA_FILE = "D:\\Survey.txt";

	private void setupQuestions()
	{
		BufferedReader br;
		try
		{
			br = new BufferedReader(new FileReader(SURVEY_DATA_FILE));
			try
			{
				String sCurrentLine;
				while ((sCurrentLine = br.readLine()) != null)
				{
					String[] dataFileData = sCurrentLine.split(",");// Reading up questions line by line
					if (dataFileData.length > 1)
					{
						questions.add(dataFileData[0].trim());
						questionTypeList.add(dataFileData[1].trim());
						if (!dataFileData[1].trim().toUpperCase().equals(SurveyOptionType.OPTION_TEXT))
							questionOption.add(dataFileData[2].trim().substring(1, dataFileData[2].length() - 2));// eleminating () Brackets
					}

				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}

		}
		catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}
	}
}
