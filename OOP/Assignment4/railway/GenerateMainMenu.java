package railway;

import java.awt.Menu;

import railbooking.menu.ActionableMenuItem;
import railbooking.menu.main.BookTicketMenu;
import railbooking.menu.main.ShowAllChartMenu;
import railbooking.menu.main.ShowAllTicketsMenu;

public class GenerateMainMenu {
	public static railbooking.menu.Menu setupMainMenu() {

		railbooking.menu.Menu menu = new railbooking.menu.Menu();
		// setting up first menu option
		ActionableMenuItem menuItem = new ActionableMenuItem();
		menuItem.setDisplayText("1. Book Tickets");
		BookTicketMenu bookTicketMenu = new BookTicketMenu();
		menuItem.setAction(bookTicketMenu);
		menu.addMenuItem(menuItem);

		// setting up second menu option
		menuItem = new ActionableMenuItem();
		menuItem.setDisplayText("2. Show All Tickets");
		ShowAllTicketsMenu allTicketsMenu = new ShowAllTicketsMenu();
		menuItem.setAction(allTicketsMenu);
		menu.addMenuItem(menuItem);

		// setting up third menu option
		menuItem = new ActionableMenuItem();
		menuItem.setDisplayText("3. Show Charts");
		ShowAllChartMenu allChartMenu = new ShowAllChartMenu();
		menuItem.setAction(allChartMenu);
		menu.addMenuItem(menuItem);

		return menu;
	}

}
