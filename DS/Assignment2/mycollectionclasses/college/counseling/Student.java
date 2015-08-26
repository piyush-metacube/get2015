package mycollectionclasses.college.counseling;

public class Student {
    private String name;
    private int marks;
    private String allotedCollegeName;
    private boolean isSeatAlloted;

    public Student(String name, int marks) {
	this.name = name;
	this.marks = marks;
    }

    // get assigned college name
    public String getAllotedCollegeName() {
	return allotedCollegeName;
    }

    // record assigned college
    public void setAllotedCollegeName(String allotedCollegeName) {
	this.allotedCollegeName = allotedCollegeName;
    }

    // to check whether the seat is been alloted or not
    public boolean isSeatAlloted() {
	return isSeatAlloted;
    }

    // setup seat allotment status
    public void setSeatAlloted(boolean isSeatAlloted) {
	this.isSeatAlloted = isSeatAlloted;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public int getMarks() {
	return marks;
    }

    public void setMarks(int marks) {
	this.marks = marks;
    }

    @Override
    public boolean equals(Object object) {
	if (!(object instanceof Student))
	    return false;
	Student student = (Student) object;
	if (this.marks <= student.getMarks())
	    return true;
	else if (this.marks < student.getMarks()) {
	    return false;
	}
	return false;
    }

    @Override
    public String toString() {
	return "Student [name=" + name + ", marks=" + marks + ", allotedCollegeName=" + allotedCollegeName + ", isSeatAlloted=" + isSeatAlloted + "]";
    }

}
