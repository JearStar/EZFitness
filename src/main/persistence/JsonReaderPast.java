package persistence;

import model.PastLog;
import model.Workout;
import model.WorkoutSession;
import model.exceptions.NegativeValueException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.Math.abs;
import static model.WorkoutSession.whichWorkoutToAdd;

/**
 * A reader that reads PastLogs from JSON data stored in file
 */

public class JsonReaderPast {
    String source;

    public JsonReaderPast(String source) {
        this.source = source;
    }

    //EFFECTS: reads WorkoutSession from file and returns it;
    // throws IOException if an error occurs reading data from file
    public PastLog read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parsePastLog(jsonObject);
    }

    //EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }
        return contentBuilder.toString();
    }

    //MODIFIES: pl
    //EFFECTS: parses pastLog from JSON object and returns it
    private PastLog parsePastLog(JSONObject jsonObject) {
        JSONArray pastLogs = jsonObject.getJSONArray("pastWorkoutSessions");
        PastLog pl = new PastLog();

        for (Object json : pastLogs) {
            JSONObject nextWorkoutSession = (JSONObject) json;
            WorkoutSession session = parseWorkoutSession(nextWorkoutSession);
            pl.addSession(session);
        }

        return pl;
    }


    //MODIFIES: ws
    //EFFECTS: parses WorkoutSession from JSON object and returns it
    private WorkoutSession parseWorkoutSession(JSONObject jsonObject) {
        String sessionName = jsonObject.getString("sessionName");
        WorkoutSession ws = new WorkoutSession();
        ws.setSessionName(sessionName);
        addListsToSession(ws, jsonObject);
        return ws;
    }

    //MODIFIES: ws
    //EFFECTS: reads finished list from memory and adds it to session
    private void addListsToSession(WorkoutSession ws, JSONObject jsonObject) {
        JSONArray finishedList = jsonObject.getJSONArray("finishedList");

        for (Object json : finishedList) {
            JSONObject nextWorkout = (JSONObject) json;
            addFinishedWorkout(ws, nextWorkout);
        }
    }

    //MODIFIES: ws
    //EFFECTS: reads finished workout from memory and adds it to finishedList
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
        try {
            currentWorkout.goThroughWorkout(infoList);
        } catch (NegativeValueException e) {
            for (double d : infoList) {
                d = abs(d);
            }
            try {
                currentWorkout.goThroughWorkout(infoList);
            } catch (NegativeValueException negativeValueException) {
                negativeValueException.printStackTrace();
                // this catch block would never occur
            }
        } finally {
            ws.addToFinalList(currentWorkout);
        }
    }
}
