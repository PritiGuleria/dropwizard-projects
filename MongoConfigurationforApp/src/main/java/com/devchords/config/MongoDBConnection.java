package com.devchords.config;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {
	private static MongoCollection<Document> insatnce;
	public static MyAppConfig appConfig;

	private MongoDBConnection() {
	};

	public static MongoCollection<Document> getCollInstance() {
		MongoClient mongoClient = new MongoClient();
		MongoDatabase mongodb = mongoClient.getDatabase(appConfig
				.getMongodbConfig().getMongodb());
		insatnce = mongodb.getCollection(appConfig.getMongodbConfig()
				.getMongoCollection());
		return insatnce;

	}

}
