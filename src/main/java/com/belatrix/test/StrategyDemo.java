package com.belatrix.test;

import java.util.logging.Level;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.belatrix.test.logger.ConsoleLogger;
import com.belatrix.test.logger.FileLogger;

@Component
public class StrategyDemo implements CommandLineRunner{
	
	@Value("${log.filepath}")
	private String filePath;

	@Override
	public void run(String... args) throws Exception {
		ContextStrategy consoleContext = new ContextStrategy(new ConsoleLogger());
		consoleContext.executeStrategy("Log en consola", Level.INFO);
		
		ContextStrategy fileContext = new ContextStrategy(new FileLogger(filePath));
		fileContext.executeStrategy("Log en file", Level.WARNING);
		
	}
	
}
