package com.belatrix.test.logger;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;

import org.apache.commons.lang3.StringUtils;

import com.belatrix.test.exceptions.BelatrixException;

public class ConsoleLogger implements LoggerStrategy {
	
	public ConsoleLogger() {
		logger.addHandler(new ConsoleHandler());
	}

	@Override
	public void log(String msg, Level level) {
		if (StringUtils.isBlank(msg))
			throw new BelatrixException("Log message cannot be empty!");
        logger.log(level, msg);
	}

}
