package model.listofexercises;

import model.Workout;

import java.util.ArrayList;

public class BarbellSquat extends Workout {
    public BarbellSquat() {
        this.workoutName = BSQUAT;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(QUADS);
        this.addMuscleGroup(GLUTES);
        this.addMuscleGroup(CALVES);
        this.addMuscleGroup(HAMSTR);
    }
}
