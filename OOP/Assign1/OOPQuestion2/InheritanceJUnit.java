package OOPQuestion2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class InheritanceJUnit
{
	@Test
	public void test()
	{
		Person personObj = new Person(23456789, "Piyush");
		assertEquals("", 23456789, personObj.getUid());
	}

	@Test
	public void test1()
	{
		Student StudentObj = new Student(23456789, "Piyush", 101);
		assertEquals("", 101, StudentObj.getStudentId());
	}
}
