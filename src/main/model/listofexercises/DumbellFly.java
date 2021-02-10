package model.listofexercises;

import model.Workout;

import java.util.ArrayList;

public class DumbellFly extends Workout {
    public DumbellFly() {
        this.workoutName = DFLY;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(PECS);
        this.addMuscleGroup(FDELTS);
    }
}
