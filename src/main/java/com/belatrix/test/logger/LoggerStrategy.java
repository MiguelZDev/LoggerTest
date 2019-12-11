package com.belatrix.test.logger;

import java.util.logging.Logger;
import java.util.logging.Level;

public interface LoggerStrategy {
	
	Logger logger = Logger.getLogger("TestLogger");
	
	void log(String msg, Level level);

}
