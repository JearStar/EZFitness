package model.listofexercises;

import model.Workout;

import java.util.ArrayList;

public class DumbellExtension extends Workout {
    public DumbellExtension() {
        this.workoutName = DEXT;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(TRI);
    }
}
