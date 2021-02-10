package model.listofexercises;

import model.Workout;

import java.util.ArrayList;

public class BarbellCurl extends Workout {
    public BarbellCurl() {
        this.workoutName = BCURL;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(BI);
    }
}


