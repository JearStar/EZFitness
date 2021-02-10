package model.listofexercises;

import model.Workout;

import java.util.ArrayList;

public class DumbellCurl extends Workout {
    public DumbellCurl() {
        this.workoutName = DCURL;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(BI);
    }
}
