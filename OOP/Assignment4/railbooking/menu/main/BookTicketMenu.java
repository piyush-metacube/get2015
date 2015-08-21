package railbooking.menu.main;

import railway.*;

import railbooking.menu.Action;

public class BookTicketMenu implements Action {

	@Override
	public void perform() {
		TicketBooking.bookTicket();
	}

}
