import java.util.HashMap;

import junit.framework.Assert;

import org.junit.Test;

public class Day5TestJUnit
{

	@Test
	public void test()
	{
		ServiceStation serviceStation = new ServiceStation();
		serviceStation.readMechanics();
		serviceStation.readCars();
		serviceStation.doAllotment();
		HashMap<String, Integer> carProcessingList = serviceStation.getCarProcessingStatus();
		HashMap<String, Integer> expCarProcessingList = new HashMap<String, Integer>();
		expCarProcessingList.put("SUV", 2);
		expCarProcessingList.put("Sedan", 2);
		expCarProcessingList.put("HB", 1);
		expCarProcessingList.put("Sedan", 2);
		Assert.assertEquals("Not matched", true, compareHashMap(expCarProcessingList, carProcessingList));

	}

	public boolean compareHashMap(HashMap<String, Integer> hash1, HashMap<String, Integer> hash2)
	{
		if (hash1.keySet().size() != hash2.keySet().size()) // in case when one of the map is containing more elements
			return false;

		for (String carType : hash1.keySet())
		{
			if (hash2.containsKey(carType) && hash1.get(carType) != hash2.get(carType)) return false;
		}

		return true;

	}
}
