package assignmentds4;

//it will hold details of customer who are booking rooms in hotel
public class Customer {
    private String name;
    private int age;

    public Customer(String name, int age) {
	this.name = name;
	this.age = age;
    }

    public String getName() {
	return name;
    }

    public int getAge() {
	return age;
    }
}
