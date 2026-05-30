package edu.citytech.counter.utility;
import java.util.function.Consumer;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DBUtility {

	private static final GsonBuilder builder = new GsonBuilder();
	private static final Gson gson = builder.create();
	private static final MongoClient mongoClient;

	static {
		String connectionString = "mongodb://localhost:27017/stocks";
		mongoClient = MongoClients.create(connectionString);
	}

	public static <T> void query(Class<T> classOfT, Consumer<T> consumer, String databaseName, String collection,
			Bson projection, Bson find, Bson sort) {

		MongoDatabase database = mongoClient.getDatabase(databaseName);
		MongoCollection<Document> collections = database.getCollection(collection);

		Consumer<? super Document> action = (e) -> {
			String jsonString = (e.toJson());
			T t = gson.fromJson(jsonString, classOfT);
			consumer.accept(t);
		};

		collections.find(find).projection(projection).sort(sort).forEach(action);
	}

}