package model;

import java.util.Scanner;

import static java.lang.Math.abs;
import static ui.FitnessApp.informUserMinutesOnCardio;

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
    public void goThroughWorkout() {
        boolean stillInputting = true;
        Scanner input = new Scanner(System.in);

        informUserMinutesOnCardio(this.getWorkoutName());
        double time = input.nextDouble();
        this.setTime(time);
    }

    //EFFECTS: retrieves summary of this workout
    public String getSummary() {
        return ("Time: " + getTime() + " minutes");
    }
}
