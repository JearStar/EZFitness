package model.listofexercises;

import model.Workout;

import java.util.ArrayList;

public class CableFly extends Workout {
    public CableFly() {
        this.workoutName = CFLY;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(PECS);
        this.addMuscleGroup(FDELTS);
    }
}
