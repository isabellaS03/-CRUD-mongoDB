/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itdel.adb.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author Isabella
 */
public class DeletingDocument {

    public static void main(String[] _args) {
        final String HOST_NAME = "localhost";

        // default port number
        final int PORT = 27017;
        
        // creating mongo client object
        MongoClient client = new MongoClient(HOST_NAME, PORT);

        // selecting the mongo database
        MongoDatabase database = client.getDatabase("contact_db");

        // selecting the mongo collection
        MongoCollection<Document> collection = database.getCollection("contact_collection");

        // preparing delete query
        Document query = new Document();

        query.put("fullname", "saras");

        // deleting the document
        collection.deleteOne(query);

        System.out.println("Document Deleted Successfully");

        // closing the client
        client.close();

    }
}
