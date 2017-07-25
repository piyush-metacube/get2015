import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceStation
{
	final String MECHANIC_DATA_FILE = "D:\\Mechanics.txt";
	final String CAR_DATA_FILE = "D:\\Cars.txt";

	private List<Mechanic> mechanicsList = new ArrayList<Mechanic>();				 		// List of Mechanics
	private List<Car> carList = new ArrayList<Car>();				 						// List of cars
	private Map<String, String> allotmentMap = new HashMap<String, String>();		 // CarNumber,Mechanic
	private Map<String, Integer> carProcessingMap = new HashMap<String, Integer>(); // summary for processing of total number of cars
	private int totalEarning = 0;

	public void readMechanics()
	{
		BufferedReader br;
		try
		{
			br = new BufferedReader(new FileReader(MECHANIC_DATA_FILE));
			String sCurrentLine;
			boolean flag = false;

			while ((sCurrentLine = br.readLine()) != null)
			{
				flag = false;
				String[] mechDetailStrings = sCurrentLine.split(",");// Reading up details line by line
				// setting up mechanic object and storing it in mechanic list
				if (mechDetailStrings.length == 4) // if in case details are less or line is whitespace
				{
					for (Mechanic mech : mechanicsList)
						if (mech.getMechID().trim().equals(mechDetailStrings[0].trim()))
						{
							flag = true;
							break;
						}
					if (flag == false)
						mechanicsList.add(new Mechanic(mechDetailStrings[0].trim(), mechDetailStrings[1].trim(), mechDetailStrings[2].trim(), Integer
								.parseInt(mechDetailStrings[3].trim())));
				}
			}

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	public void readCars()
	{
		BufferedReader br;
		try
		{
			br = new BufferedReader(new FileReader(CAR_DATA_FILE));
			String sCurrentLine;
			boolean flag = false;
			while ((sCurrentLine = br.readLine()) != null)
			{
				flag = false;
				String[] carDetailStrings = sCurrentLine.split(",");// Reading up details line by line
				// setting up car object and storing it in Cars list
				if (carDetailStrings.length == 2) // if in case details are less or line is whitespace
				{
					for (Car car : carList)
					{
						if (car.getCarNumber().equals(carDetailStrings[0].trim())) // Check for duplicate ids
						{
							flag = true;
							break;
						}
					}
					if (flag == false) carList.add(new Car(carDetailStrings[0].trim(), carDetailStrings[1].trim()));
				}
			}

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	public void doAllotment() // allotment method cars to mechanic
	{
		for (Car car : carList)
		{
			for (Mechanic mech : mechanicsList)
			{
				if (mech.isAvailable && mech.getType().equals(car.getCarType()))
				{
					allotmentMap.put(car.getCarNumber(), mech.getMechID());

					mech.isAvailable = false;

					totalEarning += mech.getRate();

					if (carProcessingMap.containsKey(car.getCarType()))
						carProcessingMap
								.replace(car.getCarType(), carProcessingMap.get(car.getCarType()), carProcessingMap.get(car.getCarType()) + 1);
					else
						carProcessingMap.put(car.getCarType(), 1);
					break;
				}
			}
		}
	}

	public int getEarning()
	{
		return totalEarning;
	}

	public Map<String, Integer> getCarProcessingStatus()
	{
		return carProcessingMap;
	}
}
