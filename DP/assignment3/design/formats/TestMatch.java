package assignment3.design.formats;

import java.util.Random;

import assignment3.design.templete.Cricket;

public class TestMatch extends Cricket {

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
	setOvers(450);
	int firstRuns = random.nextInt(1200);
	setFirstTeamRuns(firstRuns);
	int secondRuns = random.nextInt(1200);
	setSecondTeamRuns(secondRuns);
	if (firstRuns > secondRuns) {
	    setWinner(firstTeam);
	} else {
	    setWinner(secondTeam);
	}
    }

}
