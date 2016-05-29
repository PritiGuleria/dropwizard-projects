package com.devchords.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MongoConfigAppProperty {
	
	private String name;
	private String description;
	private String value;
	
	public MongoConfigAppProperty(){
		
	}

	public MongoConfigAppProperty(String name, String description, String value) {
		this.name = name;
		this.description = description;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getValue() {
		return value;
	}

	@JsonIgnore
	public boolean good() {
		return !(this.getDescription().equals(null)
		|| this.getName().equals(null) || this.getValue().equals(null));
		
	}
	
	
	

}
