package mycollectionclasses.college.counseling;

import java.util.Scanner;

import mycollectionclasses.MyArrayList;
import mycollectionclasses.Queue;

public class Councellor {
    Queue studentQueue = new Queue();
    Queue allotmentQueue = new Queue();
    Queue collegeQueue = new Queue();
    Scanner scanner = new Scanner(System.in);

    public void setupQueueOfStudent() {
	for (Object student : generateSortedStudentList().get()) {
	    if (student != null)
		studentQueue.enqueue(student);
	}
    }

    // will generate ArrayList of students..we can replace this
    // method either with console input or with file reading
    public MyArrayList generateSortedStudentList() {
	MyArrayList arrayList = new MyArrayList();

	arrayList.addElement(new Student("Suresh", 50));
	arrayList.addElement(new Student("Mahesh", 40));
	arrayList.addElement(new Student("Pramesh", 30));
	arrayList.addElement(new Student("Rajiv", 20));
	arrayList.addElement(new Student("Kishor", 70));
	arrayList.addElement(new Student("Ramcharan", 45));
	arrayList.addElement(new Student("Shivcharan", 85));
	arrayList.addElement(new Student("ShivOm", 25));
	arrayList.addElement(new Student("Shivendra", 35));
	arrayList.addElement(new Student("James", 45));
	arrayList.addElement(new Student("Anderson", 78));
	arrayList.addElement(new Student("Chang", 46));
	arrayList.addElement(new Student("Shang Ho", 47));
	arrayList.addElement(new Student("Manila", 21));
	arrayList.sort(); // sorting the data
	return arrayList;
    }

    // will generate ArrayList of colleges..we can replace this
    // method either with console input or with file reading
    public void generateCollegeQueue() {
	collegeQueue.enqueue(new Colleges("GIT", 1));
	collegeQueue.enqueue(new Colleges("VIT", 1));
	collegeQueue.enqueue(new Colleges("MIT", 1));
	collegeQueue.enqueue(new Colleges("KIT", 1));
	collegeQueue.enqueue(new Colleges("SRM", 1));
    }

    // this method will start allotment
    public void startAllotments() {
	Student student;
	Colleges college;
	int collegeListCounter = 0;
	for (int i = 0; i < studentQueue.size(); i++) {
	    // dequing the student object from student queue
	    student = (Student) studentQueue.dequeue(); // type casting it as the queue hold Object objects
	    collegeListCounter = 0;// to check how many colleges are available to each student
	    System.out.println("Student Name > " + student.getName());
	    System.out.println("Available Colleges");
	    // iterating the college queue to check for seat availablity
	    for (int j = 0; j < collegeQueue.size(); j++) {
		// dequing the college object from college queue
		college = (Colleges) collegeQueue.dequeue();// type casting it as the queue hold Object objects
		if (college.getSeats() > 0) { // if this particular college has free seats then it will print it out otherwise will continue to next
		    System.out.println(college.getNameOfCollege() + "  " + college.getSeats());
		    collegeListCounter++;
		}
		collegeQueue.enqueue(college);// re enquing the college object into the queue else data will wipe out in single iteration
	    }
	    if (collegeListCounter > 0) { // if college list counter is zero means no college is available hence wont take any inputs
		System.out.println("Enter College name to select");
		student.setAllotedCollegeName(scanner.next().trim());// setting up student object for alloted college
		student.setSeatAlloted(true); // setting up flag as true in case of allotment of seat
		reduceSeatsInCollege(student.getAllotedCollegeName()); // reduce the number of seat in that college by one
	    } else {
		System.out.println("No college Available");
	    }
	    studentQueue.enqueue(student);// re enquing the student object back to student queue
	}
    }

    // this method will reduce the number of seats available by one in case of one seat allotment
    private void reduceSeatsInCollege(String collegeName) {
	Colleges college;
	for (int j = 0; j < collegeQueue.size(); j++) {
	    college = (Colleges) collegeQueue.dequeue();
	    if (college.getNameOfCollege().equalsIgnoreCase(collegeName)) {
		college.reduceSeat();
	    }
	    collegeQueue.enqueue(college);
	}
    }

    // will print summary of college allotment
    public void printAllotments() {
	Student student;
	int noOfUnAllotedCandidate = 0;
	for (int i = 0; i < studentQueue.size(); i++) {
	    student = (Student) studentQueue.dequeue();
	    if (student.isSeatAlloted() == false) {
		++noOfUnAllotedCandidate;
		continue;
	    }
	    System.out.println(student.toString());
	    System.out.println("Student Name : " + student.getName());
	    System.out.println("College Alloted :" + student.getAllotedCollegeName());
	    studentQueue.enqueue(student);
	}
	System.out.println("Number of unalloted Candidates : " + noOfUnAllotedCandidate);
    }
}
