package model.listofexercises;

import model.Workout;

import java.util.ArrayList;

public class LandmineRow extends Workout {
    public LandmineRow() {
        this.workoutName = LMROW;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(UBACK);
        this.addMuscleGroup(LATS);
        this.addMuscleGroup(BI);
        this.addMuscleGroup(LBACK);
        this.addMuscleGroup(RDELTS);
        this.addMuscleGroup(TRAPS);
    }
}
