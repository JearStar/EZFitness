package model.listofexercises;

import model.Workout;

import java.util.ArrayList;

public class BicycleCrunch extends Workout {
    public BicycleCrunch() {
        this.workoutName = BICRUNCH;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(ABS);
        this.addMuscleGroup(OBLQ);
    }
}
