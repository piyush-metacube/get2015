package assignment3.design.templete;

public abstract class Cricket {

    protected String tossWinner, firstTeam, secondTeam, winner;
    protected int firstTeamRuns, secondTeamRuns, overs;

    public String getTossWinner() {
	return tossWinner;
    }

    public void setTossWinner(String tossWinner) {
	this.tossWinner = tossWinner;
    }

    public String getFirstTeam() {
	return firstTeam;
    }

    public void setFirstTeam(String firstTeam) {
	this.firstTeam = firstTeam;
    }

    public String getSecondTeam() {
	return secondTeam;
    }

    public void setSecondTeam(String secondTeam) {
	this.secondTeam = secondTeam;
    }

    public String getWinner() {
	return winner;
    }

    public void setWinner(String winner) {
	this.winner = winner;
    }

    public int getFirstTeamRuns() {
	return firstTeamRuns;
    }

    public void setFirstTeamRuns(int firstTeamRuns) {
	this.firstTeamRuns = firstTeamRuns;
    }

    public int getSecondTeamRuns() {
	return secondTeamRuns;
    }

    public void setSecondTeamRuns(int secondTeamRuns) {
	this.secondTeamRuns = secondTeamRuns;
    }

    public int getOvers() {
	return overs;
    }

    public void setOvers(int overs) {
	this.overs = overs;
    }

    public abstract void executePlay();

    public abstract void toss();

    public void initialize(String firstTeam, String secondTeam) {
	this.firstTeam = firstTeam;
	this.secondTeam = secondTeam;
    }

    public final void play(String firstTeam, String secondTeam) {
	initialize(firstTeam, secondTeam);
	toss();
	executePlay();
	displayResult();
    }

    public void displayResult() {
	System.out.println("\nToss won by:" + tossWinner + "\n" + firstTeam + ": " + firstTeamRuns + "\n" + secondTeam + ": " + secondTeamRuns
		+ "\nAvailable Overs: " + overs + "\nWinner: " + winner);
    }
}
