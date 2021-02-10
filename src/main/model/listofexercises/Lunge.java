package model.listofexercises;

import model.Workout;

import java.util.ArrayList;

public class Lunge extends Workout {
    public Lunge() {
        this.workoutName = LNG;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(QUADS);
        this.addMuscleGroup(CALVES);
        this.addMuscleGroup(GLUTES);
        this.addMuscleGroup(QUADS);
    }
}
