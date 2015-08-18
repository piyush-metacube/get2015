public class Train
{
	private int trainID;
	private String trainName;
	private String trainType; // int trainType; // 1 for passenger , 0 for goods
	private int trainQuota;
	private String trainStartPos;
	private String trainDestPos;
	private int trainFare;
	int travelTime;

	public Train(int id, String name, String tType, int quota, int fare, String start, String end, int tTime)
	{
		trainID = id;
		trainType = tType;
		travelTime = tTime;
		trainDestPos = end;
		trainStartPos = start;
		trainName = name;
		trainQuota = quota;
		trainFare = fare;

	}

	public int getQuota()
	{
		return trainQuota;
	}

	public int getFare()
	{
		return trainFare;
	}

	public void reduceQuota(int noOfSeats)
	{
		trainQuota -= noOfSeats;
	}

	public int getTravelTime()
	{
		return travelTime;
	}

	public int getTrainID()
	{
		return trainID;
	}

	public String getTrainType()
	{
		return trainType;
	}

	public String getTrainName()
	{
		return trainName;
	}

	public String getTrainStartPos()
	{
		return trainStartPos;
	}

	public String getTrainDestPos()
	{
		return trainDestPos;
	}

}
