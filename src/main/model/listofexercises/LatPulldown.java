package model.listofexercises;

import model.Workout;

import java.util.ArrayList;

public class LatPulldown extends Workout {
    public LatPulldown() {
        this.workoutName = LATPD;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(BI);
        this.addMuscleGroup(LATS);
        this.addMuscleGroup(UBACK);
        this.addMuscleGroup(RDELTS);
        this.addMuscleGroup(TRAPS);
    }
}
