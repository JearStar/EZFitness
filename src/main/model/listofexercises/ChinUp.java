package model.listofexercises;

import model.Workout;

import java.util.ArrayList;

public class ChinUp extends Workout {
    public ChinUp() {
        this.workoutName = CHUP;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(BI);
        this.addMuscleGroup(LATS);
        this.addMuscleGroup(RDELTS);
    }
}
