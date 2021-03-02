package model;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

/**
 * Abstract class containing all properties for cardio exercises
 */


public abstract class CardioExercise extends Workout {

    protected double time;

    //MODIFIES: this
    //EFFECTS: sets the time done for this cardio workout
    public void setTime(double time) {
        this.time = abs(time);
    }

    //EFFECTS: retrieves time spent on cardio workout
    public double getTime() {
        return this.time;
    }

    //MODIFIES: this
    //EFFECTS: goes through the workout
    public void goThroughWorkout(List<Double> infoList) {
        this.setTime(infoList.get(0));
    }

    //EFFECTS: retrieves summary of this workout
    public String getSummary() {
        return ("Time: " + getTime() + " minutes");
    }

    //EFFECTS: returns cardio exercise converted to a JSON object
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("workoutName", this.workoutName);
        List<Double> info = new ArrayList<>();

        info.add(time);

        json.put("info", info);
        return json;
    }

}
