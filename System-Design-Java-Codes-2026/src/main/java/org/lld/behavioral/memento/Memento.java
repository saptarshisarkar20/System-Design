package org.lld.behavioral.memento;

import java.util.HashMap;
import java.util.Map;

class DB_Memento {
    private Map<String, String> records;

    public DB_Memento(Map<String, String> records) {
        this.records = records;
    }

    public Map<String, String> getState() {
        return records;
    }
}

class Database {
    private Map<String, String> records;

    public Database() {
        records = new HashMap<>();
    }

    // Insert a record
    public void insert(String key, String value) {
        records.put(key, value);
        System.out.println("Inserted: " + key + " = " + value);
    }

    // Update a record
    public void update(String key, String value) {
        if (records.containsKey(key)) {
            records.put(key, value);
            System.out.println("Updated: " + key + " = " + value);
        } else {
            System.out.println("Key not found for update: " + key);
        }
    }

    // Delete a record
    public void remove(String key) {
        if (records.containsKey(key)) {
            records.remove(key);
            System.out.println("Deleted: " + key);
        } else {
            System.out.println("Key not found for deletion: " + key);
        }
    }

    // Create memento - Save current state
    public DB_Memento createMemento() {
        System.out.println("Creating database backup...");
        return new DB_Memento(records);
    }

    // Restore from memento - Rollback to saved state
    public void restoreFromMemento(DB_Memento memento) {
        records = new HashMap<>(memento.getState());
        System.out.println("Database restored from backup!");
    }

    // Display current database state
    public void displayRecords() {
        System.out.println("\n--- Current Database State ---");
        if (records.isEmpty()) {
            System.out.println("Database is empty");
        } else {
            for (Map.Entry<String, String> record : records.entrySet()) {
                System.out.println(record.getKey() + " = " + record.getValue());
            }
        }
        System.out.println("-----------------------------\n");
    }
}

class TransactionManager {
    private DB_Memento backup;

    public TransactionManager() {
        backup = null;
    }

    // Begin transaction - create backup
    public void beginTransaction(Database db) {
        System.out.println("=== BEGIN TRANSACTION ===");
        backup = db.createMemento();
    }

    // Commit transaction - discard backup
    public void commitTransaction() {
        System.out.println("=== COMMIT TRANSACTION ===");
        if (backup != null) {
            backup = null;
        }
        System.out.println("Transaction committed successfully!");
    }

    // Rollback transaction - restore from backup
    public void rollbackTransaction(Database db) {
        System.out.println("=== ROLLBACK TRANSACTION ===");
        if (backup != null) {
            db.restoreFromMemento(backup);
            backup = null;
            System.out.println("Transaction rolled back!");
        } else {
            System.out.println("No backup available for rollback!");
        }
    }
}


public class Memento {
    public static void main(String[] args) {
        Database db = new Database();
        TransactionManager txManager = new TransactionManager();

        //success scenario
        txManager.beginTransaction(db);
        db.insert("user1", "Aditya");
        db.insert("user2", "Rohit");
        txManager.commitTransaction();

        db.displayRecords();

        // Failed scenario
        txManager.beginTransaction(db);
        db.insert("user3", "Saurav");
        db.insert("user4", "Manish");

        db.displayRecords();

        // Some error -> Rollback
        System.out.println("ERROR: Something went wrong during transaction!");
        txManager.rollbackTransaction(db);

        db.displayRecords();
    }
}