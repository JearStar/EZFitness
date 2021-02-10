package model.listofexercises;

import model.Workout;

import java.util.ArrayList;

public class CableExtension extends Workout {
    public CableExtension() {
        this.workoutName = CEXT;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(TRI);
    }
}
