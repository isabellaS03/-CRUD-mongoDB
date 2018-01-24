/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itdel.adb.mongodb;

/**
 *
 * @author Isabella
 */
public class DisplayingDocument {

    public static void main(String[] _args) {
        MongoDB mongodb = new MongoDB("localhost", 27017, "contact_db");
        mongodb.setCurrentCollection("contact_collection");
        mongodb.printAllDocuments();
        mongodb.close();
    }
}
