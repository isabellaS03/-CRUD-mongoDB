/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itdel.adb.mongodb;
import com.mongodb.BasicDBObject;

/**
 *
 * @author Isabella
 */
public class InsertingDocument {

    public static void main(String[] _args) {
        MongoDB mongodb = new MongoDB("localhost", 27017, "contact_db");
        mongodb.setCurrentCollection("contact_collection");
// prepare a new document
        BasicDBObject document = new BasicDBObject();
        document.append("fullname", "saras");
        document.append("email", "saras@008.com");
        document.append("phone", "0852008008");
        mongodb.insert(document);
        mongodb.printAllDocuments();
        mongodb.close();
    }
}
