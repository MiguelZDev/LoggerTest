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
import org.springframework.boot.test.context.SpringBootTest;

import com.belatrix.test.ContextStrategy;
import com.belatrix.test.logger.DatabaseLogger;
import com.belatrix.test.logger.LoggerStrategy;
import com.belatrix.test.repository.LogRepository;

public class DatabaseLoggerTest {
	
	private final ByteArrayOutputStream databaseContent = new ByteArrayOutputStream();
	private final PrintStream originalConsole = System.out;
	
	@BeforeEach
	public void setUpStreams() {
	    System.setOut(new PrintStream(databaseContent));
	}
	
	@AfterEach
	public void restoreStreams() {
	    System.setOut(originalConsole);
	}
	
	@DisplayName("Testing ContextStrategy Type")
	@Test
	public void testDatabaseStrategy() {
		LogRepository mock = Mockito.mock(LogRepository.class);
		ContextStrategy databaseContext = new ContextStrategy(new DatabaseLogger(mock));
		assertEquals(true, databaseContext.getLoggerStrategy() instanceof DatabaseLogger);
	}
	
	@DisplayName("Testing Database Log")
	@Test
	public void testDatabaseLog() {
		LoggerStrategy mock = Mockito.mock(LoggerStrategy.class);
		
		Mockito.doAnswer((Answer) invocation -> {
	        System.out.print(invocation.getArgument(0).toString());
	        return null;
	    }).when(mock).log(Mockito.any(String.class), Mockito.any(Level.class));
		
		ContextStrategy databaseContext = new ContextStrategy(mock);
		databaseContext.executeStrategy("Testing Database Logger", Level.WARNING);
		
		// Verificar que el mensaje y lo que se escribe es lo mismo
		assertEquals("Testing Database Logger",databaseContent.toString());
	}
	

}
