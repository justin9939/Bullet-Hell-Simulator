package persistence;

import org.json.JSONObject;

public interface Writable {
    // EFFECTS: returns this as JSON object
    // from JsonSerializationDemo.java's Writable interface
    JSONObject toJson();
}
