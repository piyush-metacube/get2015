package mycollectionclasses.college.counseling;

public class Colleges {
    private String nameOfCollege;
    private int seats;

    public Colleges(String nameOfCollege, int seats) {
	this.nameOfCollege = nameOfCollege;
	this.seats = seats;
    }

    // number of seats available in college
    public int getSeats() {
	return seats;
    }

    // update Number of seats available in college
    public void reduceSeat() {
	seats -= 1;
    }

    // get name of college
    public String getNameOfCollege() {
	return nameOfCollege;
    }

    // set name of college
    public void setNameOfCollege(String nameOfCollege) {
	this.nameOfCollege = nameOfCollege;
    }
}
