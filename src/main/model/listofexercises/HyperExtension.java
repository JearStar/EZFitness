package model.listofexercises;

import model.Workout;

import java.util.ArrayList;

public class HyperExtension extends Workout {
    public HyperExtension() {
        this.workoutName = HPREXT;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(LBACK);
        this.addMuscleGroup(GLUTES);
    }
}
