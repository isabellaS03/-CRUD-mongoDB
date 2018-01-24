/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itdel.adb.mongodb;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.util.Collection;

/**
 *
 * @author Isabella
 */
public class MongoDB {

    public static final String DEFAULT_HOST = "localhost";
    public static final int DEFAULT_PORT = 27017;
    // attributes
    private MongoClient client = null;
    private DB db = null;
    private DBCollection currentCollection = null;
// constructors

    public MongoDB(String _host, int _port, String _db) {
        this.client = new MongoClient(_host, _port);
        this.db = this.client.getDB(_db);
    }

    public MongoDB(String _db) {
        this(DEFAULT_HOST, DEFAULT_PORT, _db);
    }
// closing the connection

    public void close() {
        this.client.close();
    }
// get all available collections in the database

    public Collection<String> getAllAvailableCollections() {
        return (this.db.getCollectionNames());
    }
// set the current collection

    public void setCurrentCollection(String _name) {
        if (!this.db.collectionExists(_name)) {
            throw new IllegalArgumentException("Collection does not exist.");
        }
        this.currentCollection = this.db.getCollection(_name);
    }
// inserting a new document into the current collection

    public void insert(DBObject _document) {
        this.testCollection();
        this.currentCollection.insert(_document);
    }
// executing command on a particular query

    public void update(DBObject _query, DBObject _updateCommand) {
        this.testCollection();
        this.currentCollection.update(_query, _updateCommand);
    }
// retrieve documents compliance to the given query

    protected DBCursor getAllDocuments(DBObject _query) {
        this.testCollection();
        if (_query == null) {
            return (this.currentCollection.find());
        }
        return (this.currentCollection.find(_query));
    }
// retrieve all documents in the current collection

    protected DBCursor getAllDocuments() {
        return (this.getAllDocuments(null));
    }
// print all documents complience to the given query

    public void printAllDocuments(DBObject _query) {
        DBCursor cursor = null;

        if (_query == null) {
            cursor = this.getAllDocuments();
        } else {
            cursor = this.getAllDocuments(_query);
        }
        StringBuilder sb = new StringBuilder();
        while (cursor.hasNext()) {
            DBObject document = cursor.next();
            if (sb.length() > 0) {
                sb.append("\n");
            }
            sb.append(document.toString());
        }
        System.out.println(sb.toString());
    }
// print all documents in the current collection

    public void printAllDocuments() {
        this.printAllDocuments(null);
    }
// test if the currect collection is ready to use

    protected void testCollection() {
        if (this.currentCollection == null) {
            throw new IllegalArgumentException("No collection is sellected.");
        }
    }

}
