package OOPQuestion2;

import java.util.Scanner;

public class InheritanceProgramMain
{

	public static void main(String[] args)
	{
		Scanner Sc = new Scanner(System.in);

		System.out.println("Enter the name");
		String name = Sc.nextLine();
		System.out.println("enter the id ");
		int id = Sc.nextInt();
		System.out.println("enter the  Student ID ");
		int studentid = Sc.nextInt();
		Person personobj = new Person(id, name);
		Student student = new Student(id, name, studentid);
		System.out.println(personobj);
		System.out.println(student);
		Sc.close();
	}

}
