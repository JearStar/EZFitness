package model.listofexercises;

import model.Workout;

import java.util.ArrayList;

public class DumbellShoulderPress extends Workout {
    public DumbellShoulderPress() {
        this.workoutName = DSHPR;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(TRI);
        this.addMuscleGroup(FDELTS);
    }
}
