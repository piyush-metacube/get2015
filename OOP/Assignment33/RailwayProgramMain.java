import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RailwayProgramMain
{

	static void clearScreen()
	{
		for (int clear = 0; clear < 2; clear++)
		{
			System.out.println("\n");
		}
	}

	static RailBooking railBooking = new RailBooking();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args)
	{
		while (true)
		{
			System.out.println("Railway Booking Application");
			System.out.println("Choose from options");
			System.out.println("1. Book Ticket");
			System.out.println("2. Show All Booked Tickets");
			System.out.println("3. Show Charting");
			System.out.println("4. Exit");
			int choice = sc.nextInt();

			if (choice != 1 && choice != 2 && choice != 3 && choice != 4)
				clearScreen();
			else if (choice == 1)
			{
				clearScreen();
				bookTicket();

			}
			else if (choice == 2)
			{
				clearScreen();
				showTickets();
			}
			else if (choice == 3)
			{
				clearScreen();
				showCharts();
			}
			else if (choice == 4) break;

		}
	}

		// 	will be called for booking tickets
	public static void bookTicket()
	{
		System.out.print("Enter Name : ");
		String Name = sc.next();
		sc.nextLine();  // Consume newline left-over

		System.out.println("Enter Train Type (P/G) : ");
		String TrainType = sc.next();
		if (!TrainType.toUpperCase().equals("P") && !TrainType.toUpperCase().equals("G"))
		{
			System.out.println("Invalid Train Type | Press Enter to go back");
			sc.nextLine();
		}

		sc.nextLine();  // Consume newline left-over

		System.out.println("Enter Starting Station : ");
		String startSt = sc.nextLine();
		System.out.println("Enter Destination Station : ");
		String desSt = sc.nextLine();

		List<Train> trainAvailable = sortTrainList(railBooking.getTrains(startSt, desSt, TrainType));

		boolean trainAvailStatus = showTrains(trainAvailable);
		clearScreen();
		if (trainAvailStatus)
		{
			System.out.println("Enter Train Number : ");
			int trainID = sc.nextInt();

			System.out.println("Enter Number of Seats : ");
			int noOfSeats = sc.nextInt();
			clearScreen();
			if (railBooking.isSeatAvailable(trainID, noOfSeats)) // is train available between start and end
			{
				System.out.println("Status >>> " + railBooking.getTrainQuota(trainID) + " Seats Available");

				for (Train train : trainAvailable)
				{
					if (train.getTrainID() == trainID)
					{
						int ticketID = railBooking.bookTicket(Name, trainID, train.getTrainStartPos(), train.getTrainDestPos(), train.getFare(),
								noOfSeats, TrainType);
						clearScreen();
						paymentGateway();
						clearScreen();
						railBooking.reduceQuota(trainID, noOfSeats); // reducing no of seats available
						Ticket ticketDetailsTicket = railBooking.getTicketDetails(ticketID);
						System.out.println();
						System.out.println("-----------Ticket Booked----------- ");
						System.out.println("Passenger Name : " + ticketDetailsTicket.getName());
						System.out.println("Train ID       : " + ticketDetailsTicket.getTrainID());
						System.out.println("Train Name     : " + railBooking.getTrainName(ticketDetailsTicket.getTrainID()));
						System.out.println("Train Type     : " + ticketDetailsTicket.getTrainType().toUpperCase());
						System.out.println("From           : " + ticketDetailsTicket.getTrainStartPos());
						System.out.println("To             : " + ticketDetailsTicket.getTrainDestPos());
						System.out.println("No of Seats    : " + ticketDetailsTicket.getNoOfSeats());
						System.out.println("Total Amount   : " + ticketDetailsTicket.getTotalAmount());
						break;
					}
				}
			}
			else
			{
				System.out.println("--No Seats Available ");
				trainAvailable = refineTrainList(trainAvailable, noOfSeats);
				if (trainAvailable.size() < 1)
				{
					System.out.println("--No Suitable Trains Available ");
					System.out.println("--Press Enter to go back");
					sc.nextLine();
				}
			}
		}
		else
		// in case when no trains are available for inputed locations
		{
			System.out.println("");
			System.out.println("--Press Enter to go back");
		}
	}

	// will print trains data and will return false in case of zero trains
	public static boolean showTrains(List<Train> trainAvailable)
	{
		clearScreen();

		if (trainAvailable.size() > 0)
		{
			System.out.println("------------------Trains Available------------------- ");
			System.out.println(" |TrainID|  Name   |  Type  |  From  |  To  |  Quota  |  Time  | Fare");

			for (Train train : trainAvailable)
			{
				System.out.println(" | " + train.getTrainID() + " | " + train.getTrainName() + " | " + train.getTrainType() + " | "
						+ train.getTrainStartPos() + " | " + train.getTrainDestPos() + " | " + train.getQuota() + " | " + train.getTravelTime()
						+ " | " + train.getFare());
			}
		}
		else
		{
			System.out.println("------------------ No Trains Available------------------- ");
			return false;
		}
		return true;

	}

	// will sort trainslist data
	public static List<Train> sortTrainList(List<Train> trainList)
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

	// resetting train list based on no of seats available
	public static List<Train> refineTrainList(List<Train> trainList, int noOfSeats)
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

	// to print all tickets reserved
	public static void showTickets()
	{
		List<Ticket> tickets = railBooking.getTickets();
		int tickerCounter = 0;
		for (Ticket ticketDetailsTicket : tickets)
		{
			System.out.println("-----------Ticket " + tickerCounter + "----------- ");
			System.out.println("Passenger Name \t\t\t: " + ticketDetailsTicket.getName());
			System.out.println("Train ID \t\t\t : " + ticketDetailsTicket.getTrainID());
			System.out.println("Train Name \t\t\t : " + railBooking.getTrainName(ticketDetailsTicket.getTrainID()));
			System.out.println("Train Type \t\t\t: " + ticketDetailsTicket.getTrainType());
			System.out.println("From \t\t\t : " + ticketDetailsTicket.getTrainStartPos());
			System.out.println("To \t\t\t : " + ticketDetailsTicket.getTrainDestPos());
			System.out.println("No of Seats \t\t\t: " + ticketDetailsTicket.getNoOfSeats());
		}

	}

	// for payment gateway printing
	public static boolean paymentGateway()
	{
		System.out.println();
		System.out.println("Choose from Payment Options");
		System.out.println("1. Credit Card a survey");
		System.out.println("2. Wallet all Survey");
		System.out.println("3. Net Banking");
		System.out.println("4. Cancel");
		int choice = sc.nextInt();
		if (choice != 1 && choice != 2 && choice != 3 && choice != 4)
			paymentGateway();
		else if (choice == 1)
		{
			System.out.print("Enter Credit Card Number : ");
			String ccNum = sc.next();
			sc.nextLine();  // Consume newline left-over

			System.out.print("Enter CVV Number : ");
			String cvvNum = sc.next();
			sc.nextLine();  // Consume newline left-over

			if (!ccNum.isEmpty() && !cvvNum.isEmpty())
				return true;
			else
			{
				System.out.println("Payment Process Failed Invalid Inputs| Press Enter to go back ");
				sc.nextLine();
				return false;
			}

		}
		else if (choice == 2)
		{
			System.out.println("Payment Processed | Press Enter to go back ");
			sc.nextLine();

		}
		else if (choice == 3)
		{
			System.out.print("Enter Bank Name ");
			String bankName = sc.next();
			sc.nextLine();  // Consume newline left-over

			System.out.print("Enter User Name ");
			String userName = sc.next();
			sc.nextLine();  // Consume newline left-over

			System.out.print("Enter Password ");
			String password = sc.next();
			sc.nextLine();  // Consume newline left-over
			if (!bankName.isEmpty() && !userName.isEmpty() && !password.isEmpty())
				return true;
			else
			{
				System.out.print("Payment Process Failed Invalid Inputs| Press Enter to go back ");
				sc.nextLine();
				return false;
			}
		}
		else if (choice == 4) return false;
		return false;
	}

	// will show charting for every train running
	public static void showCharts()
	{
		for (Train trains : railBooking.getAllTrains())
		{
			System.out.println("Chart for          : " + railBooking.getTrainName(trains.getTrainID()));
			System.out.println("Train ID         : " + trains.getTrainID());
			System.out.println("Remaining Seats    : " + railBooking.getTrainQuota(trains.getTrainID()));
			for (Ticket tickets : railBooking.getTrainChart(trains.getTrainID()))
			{
				System.out.println("Name : " + tickets.getName() + " Seats : " + tickets.getNoOfSeats());

			}
			System.out.println();
			System.out.println();
		}
	}
}
