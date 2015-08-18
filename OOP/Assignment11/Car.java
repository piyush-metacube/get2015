public class Car
{
	private String carNumber;
	private String carType;

	public Car(String CarNum, String CarType) // capital C in cartype
	{
		carNumber = CarNum;
		carType = CarType;
	}

	public String getCarNumber()
	{
		return carNumber;
	}

	public String getCarType()
	{
		return carType;
	}
}
