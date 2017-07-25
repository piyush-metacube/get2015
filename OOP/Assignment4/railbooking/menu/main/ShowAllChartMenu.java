package railbooking.menu.main;

import railbooking.menu.Action;
import railway.RailBooking;

public class ShowAllChartMenu implements Action{

	@Override
	public void perform() {
		RailBooking.showCharts();
	}

}
