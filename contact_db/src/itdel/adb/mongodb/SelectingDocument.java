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
public class SelectingDocument {

    public static void main(String[] _args) {
        MongoDB mongodb = new MongoDB("localhost", 27017, "contact_db");
        mongodb.setCurrentCollection("contact_collection");
// find all documents with 'saras' as it
        BasicDBObject query = new BasicDBObject();
        query.append("fullname", "saras");
        mongodb.printAllDocuments(query);
        mongodb.close();
}
    }
