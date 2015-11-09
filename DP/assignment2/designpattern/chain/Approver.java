package assignment2.designpattern.chain;

public abstract class Approver {
    protected Approver successor;

    public void setSuccessor(Approver successor) {
	this.successor = successor;
    }

    public abstract void processRequest(int days);
}
