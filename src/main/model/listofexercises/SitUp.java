package model.listofexercises;

import model.Workout;

import java.util.ArrayList;

public class SitUp extends Workout {
    public SitUp() {
        this.workoutName = SUP;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(ABS);
        this.addMuscleGroup(OBLQ);
    }
}
