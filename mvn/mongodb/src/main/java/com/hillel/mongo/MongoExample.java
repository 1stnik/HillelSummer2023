package com.hillel.mongo;

import java.util.ArrayList;

import com.mongodb.client.*;
import org.bson.Document;

public class MongoExample {
    public static void main(String[] args) {
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {

            MongoDatabase database = mongoClient.getDatabase("myTestMongoDb");

            // print existing databases
            mongoClient.listDatabaseNames().forEach(System.out::println);

            boolean collectionExists = mongoClient.getDatabase("myTestMongoDb").listCollectionNames()
                    .into(new ArrayList<>()).contains("user");
            if (!collectionExists) {
                database.createCollection("user");
            }

            // print all collections in customers database
            database.listCollectionNames().forEach(System.out::println);
//
//             create data
            MongoCollection<Document> collection = database.getCollection("user");
//            Document document = new Document();
//            document.put("name", "Oleksandr Stepurko");
//            document.put("company", "Andersen");
//            collection.insertOne(document);
//
//            // update data
//            Document query = new Document();
//            query.put("name", "Oleksandr Stepurko");
//            Document newDocument = new Document();
//            newDocument.put("company", "EPAM");
//            Document updateObject = new Document();
//            updateObject.put("$set", newDocument);
//            collection.updateOne(query, updateObject);
////
//            // read data
            Document searchQuery = new Document();
            searchQuery.put("name", "Oleksandr Stepurko");
            FindIterable<Document> cursor = collection.find(searchQuery);
            try (final MongoCursor<Document> cursorIterator = cursor.cursor()) {
                while (cursorIterator.hasNext()) {
                    System.out.println(cursorIterator.next());
                }
            }

            // delete data
            Document deleteQuery = new Document();
            deleteQuery.put("name", "Oleksandr Stepurko");
            collection.deleteMany(deleteQuery);
        }
    }
}
