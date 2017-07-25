package assignment2.designpattern.chain.concrete;

import assignment2.designpattern.chain.Approver;

public class SeniorMentor extends Approver {

    public void processRequest(int days) {
	if (days < 3) {
	    System.out.println("Request approved by senior mentor");
	} else if (successor != null) {
	    System.out.println("Request has been forwarded to HR manager");
	    successor.processRequest(days);
	}
    }
}
