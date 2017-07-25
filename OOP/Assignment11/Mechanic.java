public class Mechanic
{

	private String type;
	private int rate;
	private String mechID;
	private String name;

	public void setRate(int r)
	{
		rate = r;
	}

	public int getRate()
	{
		return rate;
	}

	public String getMechID()
	{
		return mechID;
	}

	public String getType()
	{
		return type;
	}

	boolean isAvailable;

	public Mechanic(String mechId, String mechName, String mechType, int mechRate)
	{
		mechID = mechId;
		name = mechName;
		type = mechType;
		setRate(mechRate);
		isAvailable = true;
	}
}
