package assignmentds6;

import java.util.Collections;

public class ProgramMain {

    public static void main(String[] args) {
	Employees employees = new Employees();
	employees.generateRandomData();
	employees.printDataOfEmployees();

	System.out.println();
	Collections.sort(employees.getEmployees()); // natural
	employees.printDataOfEmployees();

	System.out.println();
	Collections.sort(employees.getEmployees(), new NameComparator());// will sort as per namecomparator
	employees.printDataOfEmployees();

	// Unique Charater asignment

	UniqueCharSeq charSeq = new UniqueCharSeq();
	System.out.println(charSeq.getUniqueCharacters("This is afganishtan"));
	System.out.println(charSeq.getUniqueCharacters("India"));
	System.out.println(charSeq.getUniqueCharacters("This is afganishtan"));
    }
}
