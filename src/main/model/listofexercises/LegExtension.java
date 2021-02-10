package model.listofexercises;

import model.Workout;

import java.util.ArrayList;

public class LegExtension extends Workout {
    public LegExtension() {
        this.workoutName = LGEXT;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(QUADS);
        this.addMuscleGroup(CALVES);
        this.addMuscleGroup(GLUTES);
    }
}
