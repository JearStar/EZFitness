package model.listofexercises;

import model.Workout;

import java.util.ArrayList;

public class Clean extends Workout {
    public Clean() {
        this.workoutName = CLEAN;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(QUADS);
        this.addMuscleGroup(HAMSTR);
        this.addMuscleGroup(GLUTES);
        this.addMuscleGroup(LBACK);
        this.addMuscleGroup(ABS);
    }
}
