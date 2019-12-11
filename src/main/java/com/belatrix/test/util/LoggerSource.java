package com.belatrix.test.util;

public enum LoggerSource {
	
	CONSOLE ("1"), 
	FILE ("2"),
	DATABASE ("3");
	
	private String source;
	
	private LoggerSource(String source) {
		this.source = source;
	}

	public String getSource() {
		return source;
	}

}
