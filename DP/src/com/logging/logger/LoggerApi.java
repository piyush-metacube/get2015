package com.logging.logger;

import org.apache.log4j.Logger;

public class LoggerApi {

    private static Logger logger = Logger.getLogger(LoggerApi.class);
    private static LoggerApi loggerAPiObject = new LoggerApi();

    private LoggerApi() {

    }

    public static LoggerApi getLoggerApiInstance() {
	return loggerAPiObject;
    }

    public void logError(String error) {
	logger.error(error);
    }
}
