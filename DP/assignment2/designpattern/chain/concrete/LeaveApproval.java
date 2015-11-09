package assignment2.designpattern.chain.concrete;

import java.util.Scanner;

import assignment2.designpattern.chain.Approver;

public class LeaveApproval {

    public Approver doChaining() {
	Approver chandler = new Mentor();
	Approver harvey = new SeniorMentor();
	Approver tom = new HRManager();
	chandler.setSuccessor(harvey);
	harvey.setSuccessor(tom);
	return chandler;
    }

    public static void main(String[] args) {
	LeaveApproval leave = new LeaveApproval();
	Approver mentor = leave.doChaining();
	Scanner scan = new Scanner(System.in);
	System.out.println("Enter the number of days for leave");
	int days = scan.nextInt();
	mentor.processRequest(days);
    }

}
