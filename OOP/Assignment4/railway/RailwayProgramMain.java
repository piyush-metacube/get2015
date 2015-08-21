package railway;

public class RailwayProgramMain {

	public static void main(String args[]) {
		RailBooking.initialSetup(); // setting up train details
		railbooking.menu.Menu menu = GenerateMainMenu.setupMainMenu();
		menu.display();

	}
}
