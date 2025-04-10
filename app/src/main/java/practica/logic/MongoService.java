package practica.logic;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


public class MongoService {
    private final MongoClient client;
    private final MongoDatabase db;

    public MongoService() {
        this.client = MongoClients.create("mongodb+srv://fernandorodriguezb27:8eLDve6oHLmBiTPa@cluster-test.gn22mgw.mongodb.net/?retryWrites=true&w=majority&appName=Cluster-test");
        this.db = client.getDatabase("test2");
    }

    public MongoDatabase getDb() {
        return db;
    }

    public void testConnection() {
        System.out.println("Collections in 'test2' database:");
        for (String name : db.listCollectionNames()) {
            System.out.println("- " + name);
        }
    
        System.out.println("\nInserting a test document into 'testing' collection...");
        db.getCollection("testing").insertOne(new Document("message", "Hello from Java!"));
        System.out.println("Document inserted!");
    }
    
}
