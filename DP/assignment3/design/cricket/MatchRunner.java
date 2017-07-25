package assignment3.design.cricket;

import java.util.Scanner;

import assignment3.design.formats.TestMatch;
import assignment3.design.formats.TwentyOverMatch;
import assignment3.design.formats.OneDayMatch;
import assignment3.design.templete.Cricket;

public class MatchRunner {

    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	System.out.println("Enter the name of two teams who will play one match of each format of cricket");
	String firstName = scan.next();
	String secondName = scan.next();

	Cricket testMatch = new TestMatch();
	Cricket oneDayMatch = new OneDayMatch();
	Cricket twentyOverMatch = new TwentyOverMatch();

	testMatch.play(firstName, secondName);
	oneDayMatch.play(firstName, secondName);
	twentyOverMatch.play(firstName, secondName);

    }

}
