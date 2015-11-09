package com.logging.logger;

public class Runner {

    public static void main(String[] args) {
	LoggerApi LoggerObject = LoggerApi.getLoggerApiInstance();
	int array[] = { 1, 2, 3, 4 };
	try {
	    System.out.println(array[4]);
	} catch (ArrayIndexOutOfBoundsException n) {
	    LoggerObject.logError("Array Index Out Of Bounds Exception caught");
	}
    }
}
