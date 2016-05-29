package com.devchords.logic;

import java.util.List;

import com.devchords.model.MongoConfigAppProperty;

public class MongoConfigLogic {

	public static boolean checkValidityandSave(MongoConfigAppProperty property) {
		if (property.good()) {
			return MongoConfigDAO.save(property);
		}
		return false;
	}

	public static void deleteEntry(String name) {
		MongoConfigDAO.delete(name);

	}

	public static List<MongoConfigAppProperty> getAll() {

		return MongoConfigDAO.getAll();

	}

	public static boolean checkValidityandUpdate(MongoConfigAppProperty property) {
		
		if (property.good()) {
			return MongoConfigDAO.update(property);
		}
		return false;
		
		
	}

}
