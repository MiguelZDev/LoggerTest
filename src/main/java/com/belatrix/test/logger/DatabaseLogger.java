package com.belatrix.test.logger;

import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Level;

import org.apache.commons.lang3.StringUtils;

import com.belatrix.test.exceptions.BelatrixException;
import com.belatrix.test.repository.LogRepository;

public class DatabaseLogger implements LoggerStrategy {
	
	private final LogRepository logRepository;
	
	public DatabaseLogger(LogRepository logRepository) {
		this.logRepository = logRepository;
	}

	@Override
	public void log(String msg, Level level) {
		int levelInteger = 0;
		if (StringUtils.isBlank(msg))
			throw new BelatrixException("Log message cannot be empty!");
		switch(level.toString()) {
		  case "INFO":
			  levelInteger = 1;
		    break;
		  case "WARNING":
			  levelInteger = 2;
		    break;
		  case "ERROR":
			  levelInteger = 3;
			    break;
		  default:
			  levelInteger = 1;
		}
		String message = level + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + msg;
		logRepository.save(message, levelInteger);
		
	}

}
