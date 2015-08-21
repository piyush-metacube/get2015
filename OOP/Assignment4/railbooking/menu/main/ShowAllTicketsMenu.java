package railbooking.menu.main;

import railbooking.menu.Action;
import railway.RailBooking;
import railway.TicketBooking;

public class ShowAllTicketsMenu implements Action {

	@Override
	public void perform() {
		RailBooking.showAllTickets();
	}

}
