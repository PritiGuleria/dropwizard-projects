package com.devchords.config;

import io.dropwizard.Configuration;

public class MyAppConfig extends Configuration{
	
	private MongoConfig mongodbConfig;

	public MongoConfig getMongodbConfig() {
		return mongodbConfig;
	}

	public void setMongodbConfig(MongoConfig mongodbConfig) {
		this.mongodbConfig = mongodbConfig;
	}
	

}
