package railway;

import java.util.List;
import java.util.Scanner;

public class TicketBooking {
	public static RailBooking railBooking = new RailBooking();
	static Scanner sc = new Scanner(System.in);

	static void clearScreen() {
		for (int clear = 0; clear < 2; clear++) {
			System.out.println("\n");
		}
	}

	// will show menu options
	public void showMenu() {
		do {
			System.out.println("Railway Booking Application");
			System.out.println("Choose from options");
			System.out.println("1. Book Ticket");
			System.out.println("2. Show All Booked Tickets");
			System.out.println("3. Show Charting");
			System.out.println("4. Exit");
			int choice = sc.nextInt();

			if (choice != 1 && choice != 2 && choice != 3 && choice != 4)
				showMenu();
			switch (choice) {
			case 1:
				clearScreen();
				bookTicket();
				break;
			case 2:
				clearScreen();
				RailBooking.showAllTickets();
				break;
			case 3:
				clearScreen();
				RailBooking.showCharts();
				break;
			case 4:
				return;
			default:
				break;
			}
		} while (true);
	}

	// will be called in case of booking tickets
	public static void bookTicket() {
		System.out.print("Enter Name : ");
		String Name = sc.next();
		sc.nextLine(); // Consume newline left-over

		System.out.println("Enter Train Type (P/G) : ");
		String trainType = sc.next();

		if (!trainType.toUpperCase().equals("P") && !trainType.toUpperCase().equals("G")) {
			System.out.println("Invalid Train Type | Press Enter to go back");
			sc.nextLine();
			return;
		}
		sc.nextLine(); // Consume newline left-over

		System.out.println("Enter Starting Station : ");
		String startSt = sc.nextLine();
		System.out.println("Enter Destination Station : ");
		String desSt = sc.nextLine();

		List<Train> trainAvailable = RailBooking.sortTrainList(RailBooking.getTrains(startSt, desSt, trainType));
		clearScreen();
		boolean trainAvailStatus = RailBooking.showTrains(trainAvailable);
		clearScreen();
		if (trainAvailStatus) {
			System.out.println("Enter Train Number : ");
			int trainID = sc.nextInt();

			if (trainType.toUpperCase().equals("P"))
				System.out.println("Enter Number of Seats : ");
			else
				System.out.println("Enter Good's Weight of Seats : ");

			int noOfSeats = sc.nextInt();

			clearScreen();
			if (RailBooking.isSeatAvailable(trainID, noOfSeats)) 
			{
				System.out.println("Status >>> " + RailBooking.getTrainQuota(trainID) + " Available");

				for (Train train : trainAvailable) {
					if (train.getTrainID() == trainID) {
						int ticketID = RailBooking.bookTicket(Name, trainID, train.getTrainStartPos(),
								train.getTrainDestPos(), train.getFare(), noOfSeats, trainType);
						clearScreen();
						boolean paymentResult = PaymentGateway.paymentMenu(); 
						if (paymentResult) {
							clearScreen();
							RailBooking.reduceQuota(trainID, noOfSeats); 
							RailBooking.showTicketDetails(ticketID); 
						} else {
							RailBooking.cancelTicket(ticketID); 
							System.out.println("Payment Failure ticket");
							System.out.println("--Press Enter to go back");
							sc.nextLine();
						}
						break;
					}
				}
			} else {
				System.out.println("--Not Available ");
				trainAvailable = RailBooking.refineTrainList(trainAvailable, noOfSeats);
				if (trainAvailable.size() < 1) {
					System.out.println("--No Suitable Trains Available ");
					System.out.println("--Press Enter to go back");
					sc.nextLine();
				}
			}
		} else {// in case when no trains are available for inputed locations
			System.out.println("");
			System.out.println("--Press Enter to go back");
		}
	}
}
