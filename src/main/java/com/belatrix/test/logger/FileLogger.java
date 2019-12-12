package com.belatrix.test.logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

import org.apache.commons.lang3.StringUtils;

import com.belatrix.test.exceptions.BelatrixException;

public class FileLogger implements LoggerStrategy {
	
	// Could be helpful to declare it with RefreshScope if the properties file is placed on a external repo
	

    public FileLogger(String filePath) {
        logger.addHandler(getFileHandler(filePath));
    }
    
    public FileHandler getFileHandler(String filePath) {
    	try {
			FileHandler fh = new FileHandler(filePath);
			SimpleFormatter formatter = new SimpleFormatter();  
	        fh.setFormatter(formatter);
	        return fh;
		} catch (SecurityException | IOException e) {
			throw new BelatrixException("Error when accesing the file.",e);
		}
    }

	@Override
	public void log(String msg, Level level) {
		if (StringUtils.isBlank(msg))
			throw new BelatrixException("Log message cannot be empty!");
        logger.log(level, msg);
	}

}
