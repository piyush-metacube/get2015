package assignment3.design.formats;

import java.util.Random;

import assignment3.design.templete.Cricket;

public class OneDayMatch extends Cricket {

    public void toss() {
	Random random = new Random();
	if (random.nextBoolean()) {
	    this.tossWinner = firstTeam;
	} else {
	    this.tossWinner = secondTeam;
	}
    }

    public void executePlay() {
	Random random = new Random();
	setOvers(50);
	int firstRuns = random.nextInt(600);
	setFirstTeamRuns(firstRuns);
	int secondRuns = random.nextInt(600);
	setSecondTeamRuns(secondRuns);
	if (firstRuns > secondRuns) {
	    setWinner(firstTeam);
	} else {
	    setWinner(secondTeam);
	}

    }

}
