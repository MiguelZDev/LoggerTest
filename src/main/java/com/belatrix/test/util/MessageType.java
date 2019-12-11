package com.belatrix.test.util;

public enum MessageType {
	
	MESSAGE ("1"), 
	WARNING ("2"),
	ERROR ("3");
	
	private String type;
	
	private MessageType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
