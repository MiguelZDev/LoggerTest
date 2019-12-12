package com.belatrix.test;

import java.util.logging.Level;

import com.belatrix.test.logger.LoggerStrategy;

public class ContextStrategy {

	private LoggerStrategy loggerStrategy;

	public ContextStrategy(LoggerStrategy loggerStrategy) {
		this.loggerStrategy = loggerStrategy;
	}

	public void executeStrategy(String message, Level level) {
		loggerStrategy.log(message, level);
	}

	public LoggerStrategy getLoggerStrategy() {
		return loggerStrategy;
	}
	
}
