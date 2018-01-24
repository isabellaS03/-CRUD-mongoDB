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
public class UpdatingDocument {

    public static void main(String[] _args) {
        MongoDB mongodb = new MongoDB("localhost", 27017, "contact_db");
        mongodb.setCurrentCollection("contact_collection");
// in MongoDB, your query is in a form of document object.
// the engine would search for any document matches with the query.
        BasicDBObject query = new BasicDBObject();
        query.append("fullname", "wiro");
        BasicDBObject replacement = new BasicDBObject();
        replacement.append("fullname", "wiro sasono");
        replacement.append("email", "wiro@sableng.com");
        replacement.append("phone", "085262211212");
        BasicDBObject updateCommand = new BasicDBObject();
        updateCommand.append("$set", replacement);
        mongodb.update(query, updateCommand);
        mongodb.printAllDocuments();
        mongodb.close();
    }
}
