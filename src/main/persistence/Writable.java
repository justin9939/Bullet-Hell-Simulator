package persistence;

import org.json.JSONObject;

// represents a Writable object for JSON saving
public interface Writable {
    // EFFECTS: returns this as JSON object
    // from JsonSerializationDemo.java's Writable interface
    JSONObject toJson();
} // Writable
