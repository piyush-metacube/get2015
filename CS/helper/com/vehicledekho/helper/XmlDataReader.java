package com.vehicledekho.helper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.vehicledekho.model.Bike;
import com.vehicledekho.model.Car;
import com.vehicledekho.model.Vehicle;

public class XmlDataReader {
	private static final String XML_FILE_PATH = "C:\\Users\\Piyush\\workspace\\UMA\\VehicleDekho.com\\datarepository\\VehicleDataXML.xml";

	public static List<Vehicle> generateCarObjectFromXml() {
		List<Vehicle> carObjectList = new ArrayList<Vehicle>();
		try {
			File fXmlFile = new File(XML_FILE_PATH);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();// to remove whitespaces

			NodeList nodeList = doc.getElementsByTagName("Car");

			for (int i = 0; i < nodeList.getLength(); i++) {

				Node node = nodeList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Car car = new Car();
					Element eElement = (Element) node;
					updateCommonFeatures(car, eElement);// adding common
					// features
					car.setIsAcAvailable(Boolean.parseBoolean(eElement
							.getElementsByTagName("IsAcAvailable").item(0)
							.getTextContent()));
					car.setPowerSteering(Boolean.parseBoolean(eElement
							.getElementsByTagName("PowerSteering").item(0)
							.getTextContent()));
					car.setAccessoryKits(Boolean.parseBoolean(eElement
							.getElementsByTagName("AccessoryKit")
							.item(0).getTextContent()));
					carObjectList.add(car);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return carObjectList;
	}

	public static List<Vehicle> generateBikeObjectFromXml() {
		List<Vehicle> bikeObjectList = new ArrayList<Vehicle>();
		try {
			File fXmlFile = new File(XML_FILE_PATH);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();// to remove whitespaces

			NodeList nodeList = doc.getElementsByTagName("Bike");

			for (int i = 0; i < nodeList.getLength(); i++) {

				Node node = nodeList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Bike bike = new Bike();
					Element eElement = (Element) node;
					updateCommonFeatures(bike, eElement);// adding common
					// features
					bike.setSelfStart(Boolean.parseBoolean(eElement
							.getElementsByTagName("SelfStart").item(0)
							.getTextContent()));
					bike.setHelmetPrice(Integer.parseInt(eElement
							.getElementsByTagName("HelmetPrice").item(0)
							.getTextContent()));
					bikeObjectList.add(bike);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bikeObjectList;
	}

	private static void updateCommonFeatures(Vehicle vehicle, Element eElement) {
		vehicle.setMake(eElement.getElementsByTagName("Make").item(0)
				.getTextContent());
		vehicle.setModel(eElement.getElementsByTagName("Model").item(0)
				.getTextContent());
		vehicle.setEngineInCC(Integer.parseInt(eElement
				.getElementsByTagName("EngineInCc").item(0).getTextContent()));
		vehicle.setFuelCapacity(Integer.parseInt(eElement
				.getElementsByTagName("FuelCapacity").item(0).getTextContent()));
		vehicle.setMileage(Integer.parseInt(eElement
				.getElementsByTagName("Mileage").item(0).getTextContent()));
		vehicle.setPrice(Integer.parseInt(eElement
				.getElementsByTagName("Price").item(0).getTextContent()));
		vehicle.setRoadTax(Integer.parseInt(eElement
				.getElementsByTagName("RoadTax").item(0).getTextContent()));
	}
}
