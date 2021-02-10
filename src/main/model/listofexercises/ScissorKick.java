package model.listofexercises;

import model.Workout;

import java.util.ArrayList;

public class ScissorKick extends Workout {
    public ScissorKick() {
        this.workoutName = SCKICK;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(ABS);
        this.addMuscleGroup(OBLQ);
    }
}
