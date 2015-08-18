package OOPQuestion2;

public class Person
{
	private int uid;
	private String name;

	public Person(int uID, String nameARg)
	{
		uid = uID;
		name = nameARg;
	}

	public int getUid()
	{
		return uid;
	}

	public void setUid(int uID)
	{
		uid = uID;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String nameARg)
	{
		name = nameARg;
	}

	public String toString()
	{
		return "Name:" + name + ", uid:" + uid;
	}
}