package socialnetwork.core;

public class Person extends Entity {
    private int age;
    private String gender;

    public Person(String email, String name, int age, String gender) {
	super(email, name);
	this.age = age;
	this.gender = gender;
    }

    public int getAge() {
	return age;
    }

    public void setAge(int age) {
	this.age = age;
    }

    public String getGender() {
	return gender;
    }

    public void setGender(String gender) {
	this.gender = gender;
    }

    @Override
    public String toString() {
	return super.toString() + "[age=" + age + ", gender=" + gender + "]";
    }

    @Override
    public boolean equals(Object object) {
	if (object == null || !(object instanceof Person)) {
	    return false;
	} else {
	    Person person = (Person) object;
	    if (this.age == person.getAge()) {
		return true;
	    }
	}
	return false;
    }

    @Override
    public int hashCode() {
	int hash = 3;
	hash = 7 * hash + this.gender.hashCode();
	return hash;
    }
}
