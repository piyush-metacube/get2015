import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RailBooking
{
	public RailBooking()
	{
		setupTrains(); // will fetch all train details and update the list ticketDataList
		ticketIdCounter = 108; // setting intial ticket id counter to start from 108
	}

	private List<Train> trainDataList = new ArrayList<Train>();
	private List<Ticket> ticketDataList = new ArrayList<Ticket>();
	private final String TRAIN_DATA_FILE = "D:\\TrainData.txt";
	private int ticketIdCounter;

	// will read all train data from file
	private void setupTrains()
	{
		BufferedReader br;
		try
		{
			br = new BufferedReader(new FileReader(TRAIN_DATA_FILE));
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null)
			{
				String[] dataFileData = sCurrentLine.split(",");// Reading up questions line by line
				if (dataFileData.length == 8)
				{
					// new Train(id, name, tType, quota, fare, startPos, endPos, tTime);
					trainDataList.add(new Train(Integer.parseInt(dataFileData[0].trim()), dataFileData[1].trim(), dataFileData[2].trim(), Integer
							.parseInt(dataFileData[3].trim()), Integer.parseInt(dataFileData[4].trim()), dataFileData[5].trim(), dataFileData[6]
							.trim(), Integer.parseInt(dataFileData[7].trim())));
				}

			}

		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
	}

	public List<Ticket> getTickets()
	{
		return ticketDataList;
	}

	// will throw available trains between start and destination
	public List<Train> getTrains(String startPos, String DestPos, String TrainType)
	{
		List<Train> trainsAvail = new ArrayList<Train>();

		for (Train train : trainDataList)
		{
			if (train.getTrainType().toUpperCase().equals(TrainType.trim().toUpperCase())
					&& train.getTrainStartPos().trim().toUpperCase().equals(startPos.toUpperCase().trim())
					&& train.getTrainDestPos().trim().toUpperCase().equals(DestPos.toUpperCase().trim()))
			{
				trainsAvail.add(train); // adding only single type of trains
			}
		}
		return trainsAvail;
	}

	// return all running trains
	public List<Train> getAllTrains()
	{
		return trainDataList;
	}

	public int bookTicket(String tname, int trainid, String startPlace, String destPlace, int tprice, int noOfSeats, String trainType)
	{
		int ticketID = genTicketId();
		Ticket ticket = new Ticket(tname, ticketID, trainid, startPlace, destPlace, tprice * noOfSeats, noOfSeats, trainType);
		ticketDataList.add(ticket); // booking ticket
		return ticketID;
	}

	// to reduce train seat availablity
	public void reduceQuota(int trainID, int noOfSeats) // after the ticket booking
	{
		for (Train train : trainDataList)
		{
			if (train.getTrainID() == trainID)
			{
				train.reduceQuota(noOfSeats);
				break;
			}
		}
	}

	// will be used at ticker ID generator
	private int genTicketId()
	{
		return ticketIdCounter++;
	}

	// will return false in case of desired seats are not available
	public boolean isSeatAvailable(int trainID, int noOfSeatsRequired)
	{
		for (Train train : trainDataList)
		{
			if (train.getTrainID() == trainID)
			{
				if (train.getQuota() - noOfSeatsRequired > 0)
					return true;
				else
					return false;
			}
		}
		return false;
	}

	// will return ticket details based on ticket id
	public Ticket getTicketDetails(int ticketID)
	{
		for (Ticket ticket : ticketDataList)
		{
			if (ticket.getTicketId() == ticketID)
			{
				return ticket;
			}
		}
		return null;
	}

	// will return train seat availablity based on train id
	public int getTrainQuota(int trainID)
	{

		for (Train train : trainDataList)
		{
			if (train.getTrainID() == trainID)
			{
				return train.getQuota();
			}
		}
		return 0;
	}

	// will return train name based on train id
	public String getTrainName(int trainID)
	{
		for (Train train : trainDataList)
		{
			if (train.getTrainID() == trainID)
			{
				return train.getTrainName();
			}
		}
		return "";
	}

	// will generate and return train chart
	public List<Ticket> getTrainChart(int trainID)
	{
		List<Ticket> reservedSeats = new ArrayList<Ticket>();
		for (Ticket ticket : ticketDataList)
		{
			if (ticket.getTrainID() == trainID) reservedSeats.add(ticket);
		}
		return reservedSeats;

	}
}
