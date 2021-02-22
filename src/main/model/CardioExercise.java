package model;

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
}
