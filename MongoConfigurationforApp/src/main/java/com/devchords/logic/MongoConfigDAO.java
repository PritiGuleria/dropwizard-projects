package com.devchords.logic;

import java.util.ArrayList;
import java.util.List;

import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;

import com.devchords.config.MongoDBConnection;
import com.devchords.model.MongoConfigAppProperty;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.bulk.UpdateRequest;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;

public class MongoConfigDAO {

	public static boolean save(MongoConfigAppProperty property) {

		Document doc = new Document("_id", property.getName())
				.append("name", property.getName())
				.append("description", property.getDescription())
				.append("value", property.getValue());

		MongoCollection<Document> coll = MongoDBConnection.getCollInstance();

		try {
			coll.insertOne(doc);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}

	}

	public static void delete(String name) {
		MongoCollection<Document> coll = MongoDBConnection.getCollInstance();
		coll.deleteOne(Filters.eq("name", name));

	}

	public static List<MongoConfigAppProperty> getAll() {
		MongoCollection<Document> coll = MongoDBConnection.getCollInstance();
		FindIterable<Document> docIterator = coll.find();
		List<MongoConfigAppProperty> list = new ArrayList<MongoConfigAppProperty>();

		for (Document doc : docIterator) {
			String name = doc.getString("name");
			String description = doc.getString("description");
			String value = doc.getString("value");
			MongoConfigAppProperty property = new MongoConfigAppProperty(name,
					description, value);
			list.add(property);
		}
		return list;

	}

	public static boolean update(MongoConfigAppProperty property) {
		MongoCollection<Document> coll = MongoDBConnection.getCollInstance();
		try {
			
			Document update = new Document("value", property.getValue());
			update.append("description", property.getDescription());
			Document doc = new Document("$set", update);
			coll.updateOne(Filters.eq("_id",property.getName()),doc);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
