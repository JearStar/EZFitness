package model.listofexercises;

import model.Workout;

import java.util.ArrayList;

public class ReverseDumbellFly extends Workout {
    public ReverseDumbellFly() {
        this.workoutName = RVDFLY;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(LDELTS);
        this.addMuscleGroup(RDELTS);
        this.addMuscleGroup(UBACK);
        this.addMuscleGroup(TRAPS);
    }
}
