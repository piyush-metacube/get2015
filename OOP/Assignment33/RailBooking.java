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
					trainDataList.add(new Train(Integer.parseInt(dataFileData[0].trim()), dataFileData[1].trim(), dataFileData[2].trim(), Integer.parseInt(dataFileData[3].trim()), Integer.parseInt(dataFileData[4].trim()), dataFileData[5].trim(), dataFileData[6].trim(), Integer.parseInt(dataFileData[7].trim())));
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
			if (train.getTrainType().toUpperCase().equals(TrainType.trim().toUpperCase()) && train.getTrainStartPos().trim().toUpperCase().equals(startPos.toUpperCase().trim()) && train.getTrainDestPos().trim().toUpperCase().equals(DestPos.toUpperCase().trim()))
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

	// will show charting for every train running
	public void showCharts()
	{
		for (Train trains : getAllTrains())
		{
			System.out.println("Chart for          : " + getTrainName(trains.getTrainID()));
			System.out.println("Train ID         : " + trains.getTrainID());
			System.out.println("Remaining Seats    : " + getTrainQuota(trains.getTrainID()));
			for (Ticket tickets : getTrainChart(trains.getTrainID()))
			{
				System.out.println("Name : " + tickets.getName() + " Seats : " + tickets.getNoOfSeats());
			}
			System.out.println();
			System.out.println();
		}
	}

	// to print all tickets reserved
	public void showAllTickets()
	{
		int tickerCounter = 1;
		for (Ticket ticketDetailsTicket : getTickets())
		{
			System.out.println("-----------Ticket " + tickerCounter + "----------- ");
			System.out.println("Name          : " + ticketDetailsTicket.getName());
			System.out.println("Train ID      : " + ticketDetailsTicket.getTrainID());
			System.out.println("Train Name    : " + getTrainName(ticketDetailsTicket.getTrainID()));
			System.out.println("Train Type    : " + ticketDetailsTicket.getTrainType().toUpperCase());
			System.out.println("From          : " + ticketDetailsTicket.getTrainStartPos());
			System.out.println("To            : " + ticketDetailsTicket.getTrainDestPos());
			if (ticketDetailsTicket.getTrainType().toUpperCase().equals("P"))
				System.out.println("No of Seats   : " + ticketDetailsTicket.getNoOfSeats());
			else
				System.out.println("Good's Weight : " + ticketDetailsTicket.getNoOfSeats());
			System.out.println();
		}
	}

	// to print specific tickets reserved
	public void showTicketDetails(int ticketId)
	{
		Ticket ticketDetails = getTicketDetails(ticketId);
		System.out.println();
		System.out.println("-----------Ticket Booked----------- ");
		System.out.println("Name : " + ticketDetails.getName());
		System.out.println("Train ID       : " + ticketDetails.getTrainID());
		System.out.println("Train Name     : " + getTrainName(ticketDetails.getTrainID()));
		System.out.println("Train Type     : " + ticketDetails.getTrainType().toUpperCase());
		System.out.println("From           : " + ticketDetails.getTrainStartPos());
		System.out.println("To             : " + ticketDetails.getTrainDestPos());
		if (ticketDetails.getTrainType().toUpperCase().equals("P"))
			System.out.println("No of Seats    : " + ticketDetails.getNoOfSeats());
		else
			System.out.println("Weight         : " + ticketDetails.getNoOfSeats());
		System.out.println("Total Amount   : " + ticketDetails.getTotalAmount());
		System.out.println();
	}

	// will print trains data as per argumented list and will return false in case of zero trains
	public boolean showTrains(List<Train> trainAvailable)
	{
		if (trainAvailable.size() > 0)
		{
			System.out.println("------------------Trains Available------------------- ");
			System.out.println(" |TrainID|  Name   |  Type  |  From  |  To  |  Quota  |  Time  | Fare");

			for (Train train : trainAvailable)
			{
				System.out.println(" | " + train.getTrainID() + " | " + train.getTrainName() + " | " + train.getTrainType() + " | " + train.getTrainStartPos() + " | " + train.getTrainDestPos() + " | " + train.getQuota() + " | " + train.getTravelTime() + " | " + train.getFare());
			}
		}
		else
		{
			System.out.println("------------------ No Trains Available------------------- ");
			return false;
		}
		return true;
	}

	// resetting train list based on no of seats available
	public List<Train> refineTrainList(List<Train> trainList, int noOfSeats)
	{
		List<Train> refTrainLs = new ArrayList<Train>();

		for (Train train : trainList)
		{
			if (train.getQuota() - noOfSeats >= 0)
			{
				refTrainLs.add(train);
			}
		}
		return refTrainLs;
	}

	// will sort trainslist data
	public List<Train> sortTrainList(List<Train> trainList)
	{
		for (int i = 0; i < trainList.size(); i++)
		{
			for (int j = 0; j < trainList.size(); j++)
			{
				if (trainList.get(i).getTravelTime() < trainList.get(j).getTravelTime())
				{
					Train temp = trainList.get(i);
					trainList.set(i, trainList.get(j));
					trainList.set(j, temp);
				}
			}
		}
		return trainList;
	}

	// cancellation of ticket in case of payment failure
	public void cancelTicket(int ticketId)
	{
		for (int i = 0; i < ticketDataList.size(); i++)
		{
			if (ticketDataList.get(i).getTicketId() == ticketId) ticketDataList.remove(i);
		}
	}
}
