package assignmentds4;

import java.util.ArrayList;
import java.util.List;

/*	Assignment DS4 Q2.
 * 	Write a program to allot rooms in guest house. rooms can be identified by their room number and
 *	allotment is based age of Guest. (Use Hash Table techniques for allocation)
 *	Given : There are N numbers of rooms and K is the count of guests,
 *	where N is a prime number and N > K
 *
 *	customer age is used as key and for key collision.. preventive measures has been coded
 */
public class HashTable {
    private int[] rooms;
    private Customer[] customers;
    private int occupiedRooms;
    private PrimeGenerator primeGenerator;// key generator for hashtable
    private final int N = 51; // TOTAL_NUMBER_OF_ROOMS

    public HashTable() {
	rooms = new int[N];
	customers = new Customer[50];
	occupiedRooms = 0;
	primeGenerator = new PrimeGenerator();
    }

    // will set any data value on location of key
    public void put(int key, Customer customer) {
	if (isExiting(key) == false) {
	    rooms[occupiedRooms++] = key;
	    customers[occupiedRooms - 1] = customer;
	}
    }

    // to check whether any key is existing or not
    public boolean isExiting(int key) {
	for (int i = 0; i < rooms.length; i++) {
	    if (rooms[i] == key) {
		return true;
	    }
	}
	return false;
    }

    // fetch dataObject location based on key
    private int getCustomerIndex(int key) {
	for (int i = 0; i < rooms.length; i++) {
	    if (rooms[i] == key) {
		return i;
	    }
	}
	return -1;
    }

    // will return data based on given key
    public Customer get(int key) {
	int index = getCustomerIndex(key);
	if (index != -1)
	    return customers[index];
	else
	    return null;
    }

    // it will generate key based on customer age
    public int generateKeyBasedOnCustomerAge(int age) {
	if (age > 0) {
	    age *= primeGenerator.getPrime();
	    // if any number is not prime,it will be converted to prime by adding 1,2,3
	    if (!primeGenerator.isPrime(age)) {
		for (int i = 1; i <= 3; i++) {
		    age += i; // adding 1,2,3 and then checking whether it gets prime...if then returning prime
		    if (!primeGenerator.isPrime(age)) {
			return age;
		    }
		}
	    }
	}
	return -1;
    }

    // will print all allotments
    public void printAllotments() {
	for (int roomIndex : rooms) {
	    System.out.println("Customer Name : " + customers[getCustomerIndex(roomIndex)].getName() + "\n Room Number : " + roomIndex);
	}
    }

    // will generate data for customers
    public List<Customer> generateCutomers() {
	List<Customer> customers = new ArrayList<Customer>();
	customers.add(new Customer("Harish", 25));
	customers.add(new Customer("Suresh", 26));
	customers.add(new Customer("Ramesh", 27));
	customers.add(new Customer("Mahesh", 28));
	customers.add(new Customer("Kishore", 29));
	customers.add(new Customer("Rafiq", 30));
	return customers;
    }

    public static void main(String[] args) {
	HashTable customerHashTable = new HashTable();
	int key = 0;
	for (Customer customer : customerHashTable.generateCutomers()) {
	    key = customerHashTable.generateKeyBasedOnCustomerAge(customer.getAge());
	    if (key != -1) {
		customerHashTable.put(key, customer);
	    }
	}
	customerHashTable.printAllotments();
    }
}
