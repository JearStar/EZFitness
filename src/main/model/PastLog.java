package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PastLog implements Writable {
    List<WorkoutSession> pastWorkoutSessions;

    public PastLog() {
        pastWorkoutSessions = new ArrayList<>();
    }

    public void addSession(WorkoutSession ws) {
        pastWorkoutSessions.add(ws);
    }

    public List<WorkoutSession> getPastWorkoutSessions() {
        return this.pastWorkoutSessions;
    }


    //MODIFIES: this
    //EFFECTS: removes a session from pastWorkoutSessions given the name of the session
    public void removeWorkoutSession(String s) {
        Iterator<WorkoutSession> i = pastWorkoutSessions.iterator();
        while (i.hasNext()) {
            WorkoutSession ws = i.next();
            if (ws.getSessionName().toLowerCase().equals(s.toLowerCase())) {
                i.remove();
            }
        }
    }

    //MODIFIES: this
    //EFFECTS: clears all workout sessions from pastWorkoutSessions
    public void clearAllWorkoutSessions() {
        Iterator<WorkoutSession> i = pastWorkoutSessions.iterator();
        while (i.hasNext()) {
            WorkoutSession ws = i.next();
            i.remove();

        }
    }


    //MODIFIES: this
    //EFFECTS: returns a list of all session names
    public List<String> getPastSessionNames() {
        List<String> pastNames = new ArrayList<>();
        for (WorkoutSession ws : getPastWorkoutSessions()) {
            pastNames.add(ws.getSessionName());
        }
        return pastNames;
    }

    //EFFECTS: Returns this PastLog converted to a JSON Object
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("pastWorkoutSessions", pastWorkoutSessionsToJson());

        return json;
    }

    //EFFECTS: Returns pastWorkoutSessions converted to a JSON Object
    public JSONArray pastWorkoutSessionsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (WorkoutSession ws : pastWorkoutSessions) {
            jsonArray.put(ws.toJson());
        }
        return jsonArray;
    }

}
