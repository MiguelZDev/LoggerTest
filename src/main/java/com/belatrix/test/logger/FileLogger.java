package com.belatrix.test.logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import com.belatrix.test.exceptions.BelatrixException;

public class FileLogger implements LoggerStrategy {
	
	@Value("${log.file.path}")
	private String filePath;

    public FileLogger() {
        logger.addHandler(getFileHandler(filePath));
    }
    
    public FileHandler getFileHandler(String filePath) {
    	try {
			return new FileHandler(filePath);
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
