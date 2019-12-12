package com.belatrix.logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.logging.Level;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import com.belatrix.test.ContextStrategy;
import com.belatrix.test.logger.FileLogger;
import com.belatrix.test.logger.LoggerStrategy;

public class FileLoggerTest {
	
	private final String filePath = "Somepath";
	
	private final ByteArrayOutputStream fileContent = new ByteArrayOutputStream();
	private final PrintStream originalConsole = System.out;
	
	@BeforeEach
	public void setUpStreams() {
	    System.setOut(new PrintStream(fileContent));
	}
	
	@AfterEach
	public void restoreStreams() {
	    System.setOut(originalConsole);
	}
	
	@DisplayName("Testing ContextStrategy Type")
	@Test
	public void testFileStrategy() {
		ContextStrategy fileContext = new ContextStrategy(new FileLogger(filePath));
		assertEquals(true, fileContext.getLoggerStrategy() instanceof FileLogger);
	}
	
	@DisplayName("Testing File Log")
	@Test
	public void testFileLog() {
		LoggerStrategy mock = Mockito.mock(LoggerStrategy.class);
		
		Mockito.doAnswer((Answer) invocation -> {
			System.out.print(invocation.getArgument(0).toString());
	        return null;
	    }).when(mock).log(Mockito.any(String.class), Mockito.any(Level.class));
		
		ContextStrategy fileContext = new ContextStrategy(mock);
		fileContext.executeStrategy("Testing File Logger", Level.WARNING);
		
		// Verificar que el mensaje y lo que se escribe es lo mismo
		assertEquals("Testing File Logger",fileContent.toString());
		
	}

}
