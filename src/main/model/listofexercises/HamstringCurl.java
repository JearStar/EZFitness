package model.listofexercises;

import model.Workout;

import java.util.ArrayList;

public class HamstringCurl extends Workout {
    public HamstringCurl() {
        this.workoutName = HMCURL;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(HAMSTR);
        this.addMuscleGroup(GLUTES);
    }
}
