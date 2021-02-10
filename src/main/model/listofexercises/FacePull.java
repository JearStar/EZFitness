package model.listofexercises;

import model.Workout;

import java.util.ArrayList;

public class FacePull extends Workout {
    public FacePull() {
        this.workoutName = FPULL;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(BI);
        this.addMuscleGroup(RDELTS);
    }
}
