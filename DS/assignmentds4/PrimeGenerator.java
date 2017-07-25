package assignmentds4;

public class PrimeGenerator {
    private int generatedPrime = 3; // initial generated prime will be three
    private final int MAX_LIMIT = 10000;// last limit to check prime numbers

    // to check whether a number is prime or not
    public boolean isPrime(int number) {
	for (int i = 2; i <= number / 2; i++) {
	    if (number % i == 0) {
		return false;
	    }
	}
	return true;
    }

    // it will generate unique prime numbers on demand
    public int getPrime() {
	for (int i = generatedPrime + 1; i < MAX_LIMIT; i++) {// loop through the numbers one by one
	    if (isPrime(i)) { // check to see if the number is prime
		generatedPrime = i;
		return generatedPrime;
	    }
	}
	return -1;
    }
}
