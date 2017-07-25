import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day6ProgramMain
{
	static Survey survey = new Survey();

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		while (true)
		{
			System.out.println("Survey Application");
			System.out.println("Choose from options");
			System.out.println("1. Fill a survey");
			System.out.println("2. Show all Survey");
			System.out.println("3. Single Select Stats");
			System.out.println("4. Exit");
			int choice = sc.nextInt();
			if (choice != 1 && choice != 2 && choice != 3 && choice != 4)
				clearScreen();
			else if (choice == 1)
			{
				fillSurvey();
				clearScreen();
			}
			else if (choice == 2)
			{
				checkSurvey();
				clearScreen();
			}
			else if (choice == 3)
			{
				showStats();
				clearScreen();
			}
			else if (choice == 4) break;

		}
	}

	static void clearScreen()
	{
		for (int clear = 0; clear < 50; clear++)
		{
			System.out.println("\n");
		}
	}

	// method which will called at time of taking inputs
	static void fillSurvey()
	{
		Scanner sc = new Scanner(System.in);
		List<String> userAns = new ArrayList<String>();
		for (int i = 0; i < survey.getQuestions().size(); i++)
		{
			System.out.println("Q. " + survey.getQuestions().get(i));
			if (!survey.getOptionType().get(i).trim().toUpperCase().equals(SurveyOptionType.OPTION_TEXT))
			{
				String[] optionList = survey.getOptions().get(i).split("/");
				for (String string : optionList)
				{
					System.out.println("> " + string);
				}
			}
			if (survey.getOptionType().get(i).trim().toUpperCase().equals(SurveyOptionType.OPTION_SINGLE_SELECT)
					|| survey.getOptionType().get(i).trim().toUpperCase().equals(SurveyOptionType.OPTION_TEXT))
			{
				System.out.print(">>>");
				userAns.add(sc.nextLine());
			}
			else
			{
				System.out.println("( Add '/' inbetween two choices)");
				System.out.println(">>>");
				userAns.add(sc.nextLine().trim());
			}
		}
		survey.setUserInput(userAns);
	}

	// method which will called at time of printing user inputs
	static void checkSurvey()
	{
		Scanner sc = new Scanner(System.in);

		int pNum = 0;
		for (SurveyUserInputs userData : survey.getUserData())
		{
			System.out.println();
			System.out.println("Participant " + pNum++);
			List<String> userAns = userData.getInputs();
			for (int i = 0; i < survey.getQuestions().size(); i++)
			{
				System.out.println();
				System.out.print("Q." + (i + 1) + " " + survey.getQuestions().get(i));
				if (!survey.getOptionType().get(i).trim().toUpperCase().equals(SurveyOptionType.OPTION_TEXT))
				{
					System.out.print("(" + survey.getOptions().get(i) + ")");
				}
				System.out.println();
				System.out.println(">" + userAns.get(i));
			}
		}
		if (survey.getUserData().size() <= 0) System.out.println("Nothing recorded yet");
		String t = sc.nextLine();
	}

	// method which will called at time of printing report
	static void showStats()
	{
		Scanner sc = new Scanner(System.in);
		if (survey.getUserData().size() <= 0)
			System.out.println("Nothing recorded yet");
		else
			for (int i = 0; i < 4; i++)
				System.out.println(survey.getReport(i));
		String t = sc.nextLine();

	}
}
