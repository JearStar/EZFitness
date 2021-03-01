package persistence;

import model.Workout;
import model.WorkoutSession;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static model.WorkoutSession.whichWorkoutToAdd;

// A reader that reads WorkoutSession from JSON data stored in file
public class JsonReader {
    private String source;

    //EFFECTS: constructs a reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    //EFFECTS: reads WorkoutSession from file and returns it;
    // throws IOException if an error occurs reading data from file
    public WorkoutSession read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseWorkoutSession(jsonObject);
    }

    //EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }
        return contentBuilder.toString();
    }


    //EFFECTS: parses workroom from JSON object and returns it
    private WorkoutSession parseWorkoutSession(JSONObject jsonObject) {
        String sessionName = jsonObject.getString("sessionName");
        WorkoutSession ws = new WorkoutSession();
        ws.setSessionName(sessionName);
        addListsToSession(ws, jsonObject);
        return ws;
    }

    private void addListsToSession(WorkoutSession ws, JSONObject jsonObject) {
        JSONArray finishedList = jsonObject.getJSONArray("finishedList");
        JSONArray remainingList = jsonObject.getJSONArray("remainingList");

        for (Object json : finishedList) {
            JSONObject nextWorkout = (JSONObject) json;
            addFinishedWorkout(ws, nextWorkout);
        }

        for (Object json : remainingList) {
            JSONObject nextWorkout = (JSONObject) json;
            addRemainingWorkout(ws, nextWorkout);
        }
    }

    private void addFinishedWorkout(WorkoutSession ws, JSONObject jsonObject) {
        String workoutName = jsonObject.getString("workoutName");
        List<Double> infoList = new ArrayList<>();
        JSONArray jsonInfoList = jsonObject.getJSONArray("info");

        if (jsonInfoList != null) {
            for (int i = 0; i < jsonInfoList.length(); i++) {
                infoList.add(jsonInfoList.getDouble(i));
            }
        }

        Workout currentWorkout = whichWorkoutToAdd(workoutName);
        currentWorkout.goThroughWorkout(infoList);

        ws.addToFinalList(currentWorkout);
    }

    private void addRemainingWorkout(WorkoutSession ws, JSONObject jsonObject) {
        String workoutName = jsonObject.getString("workoutName");
        ws.addWorkout(whichWorkoutToAdd(workoutName));
    }

}
