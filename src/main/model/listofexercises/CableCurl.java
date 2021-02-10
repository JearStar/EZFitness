package model.listofexercises;

import model.Workout;

import java.util.ArrayList;

public class CableCurl extends Workout {
    public CableCurl() {
        this.workoutName = CCURL;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(BI);
    }
}
