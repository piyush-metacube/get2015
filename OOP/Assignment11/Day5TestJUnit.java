import java.util.HashMap;
import java.util.Map;

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
		Map<String, Integer> carProcessingMap = serviceStation.getCarProcessingStatus();
		Map<String, Integer> expCarProcessingMap = new HashMap<String, Integer>();
		expCarProcessingMap.put("SUV", 2);
		expCarProcessingMap.put("Sedan", 2);
		expCarProcessingMap.put("HB", 1);
		expCarProcessingMap.put("Sedan", 2);
		Assert.assertEquals("Not matched", true, compareHashMap(expCarProcessingMap, carProcessingMap));
	}

	public boolean compareHashMap(Map<String, Integer> hash1, Map<String, Integer> hash2)
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
