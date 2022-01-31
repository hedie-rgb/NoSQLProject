import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Arrays;
import java.util.function.Consumer;

public class ConnectToMongo {
    public static void main(String[] args) {

        // Database Details
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoCredential credential = MongoCredential.createCredential("hex"
                , "Flight", "hax1234".toCharArray());
        System.out.println("Credentials: " + credential);
        MongoDatabase database = mongoClient.getDatabase("Flight");

         //Create Collection
        database.createCollection("Flights");

        // Create Document
      //  Document document = new Document("flightNumber", "2343")
      //          .append("airport", "ISA")
       //         .append("country", "France")
       //         .append("destination", Arrays.asList("Italy", "USA"));

        // Insert Document to Collection
        //database.getCollection("test").insertOne(document);

        // Print data in collection
        database.getCollection("Flights").find()
                .forEach((Consumer<? super Document>) System.out::println);
        database.listCollectionNames().forEach((Consumer<? super String>) System.out::println);

        // Drop Collection
        //database.getCollection("presentations").drop();
    }
}
