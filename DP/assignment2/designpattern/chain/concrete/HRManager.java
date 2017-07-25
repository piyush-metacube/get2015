package assignment2.designpattern.chain.concrete;

import assignment2.designpattern.chain.Approver;

public class HRManager extends Approver {

    public void processRequest(int days) {
	if (days < 6) {
	    System.out.println("Request approved by HR manager");
	} else {
	    System.out.println("Can not approve this request.");
	}
    }
}
