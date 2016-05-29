package com.devchords.config;

import io.dropwizard.Configuration;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MongoConfig extends Configuration {
	@JsonProperty
	private String mongoUrl;
	
	@JsonProperty
	private String mongodb;
	
	@JsonProperty
	private String mongoCollection;

	public String getMongoUrl() {
		return mongoUrl;
	}

	public void setMongoUrl(String mongoUrl) {
		this.mongoUrl = mongoUrl;
	}
	public String getMongodb() {
		return mongodb;
	}

	public void setMongodb(String mongodb) {
		this.mongodb = mongodb;
	}

	public String getMongoCollection() {
		return mongoCollection;
	}

	public void setMongoCollection(String mongoCollection) {
		this.mongoCollection = mongoCollection;
	}

}
