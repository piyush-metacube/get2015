public class Ticket
{
	private String name;
	private int id;
	private int trainID;
	private String destination;
	private String from;
	private int totalPrice;
	private int noOfseats;
	private String trainType;

	public Ticket(String tname, int tID, int trainid, String start, String dest, int tprice, int seats, String tType)
	{
		name = tname;
		id = tID;
		trainID = trainid;
		destination = dest;
		from = start;
		totalPrice = tprice;
		noOfseats = seats;
		trainType = tType;
	}

	public int getTicketId()
	{
		return id;
	}

	public int getAmount()
	{
		return totalPrice;
	}

	public int getNoOfSeats()
	{
		return noOfseats;
	}

	public int getTotalAmount()
	{
		return totalPrice;
	}

	public int getTrainID()
	{
		return trainID;
	}

	public String getTrainType()
	{
		return trainType;
	}

	public String getName()
	{
		return name;
	}

	public String getTrainStartPos()
	{
		return from;
	}

	public String getTrainDestPos()
	{
		return destination;
	}

}
