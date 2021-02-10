package model.listofexercises;

import model.Workout;

import java.util.ArrayList;

public class PullUp extends Workout {
    public PullUp() {
        this.workoutName = PLUP;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(TRAPS);
        this.addMuscleGroup(BI);
        this.addMuscleGroup(RDELTS);
        this.addMuscleGroup(UBACK);
        this.addMuscleGroup(LATS);
    }
}
