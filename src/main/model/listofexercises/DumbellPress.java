package model.listofexercises;

import model.Workout;

import java.util.ArrayList;

public class DumbellPress extends Workout {
    public DumbellPress() {
        this.workoutName = DPRESS;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(PECS);
        this.addMuscleGroup(TRI);
        this.addMuscleGroup(FDELTS);
    }
}
