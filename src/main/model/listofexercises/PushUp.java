package model.listofexercises;

import model.Workout;

import java.util.ArrayList;

public class PushUp extends Workout {
    public PushUp() {
        this.workoutName = PSUP;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(PECS);
        this.addMuscleGroup(TRI);
        this.addMuscleGroup(FDELTS);
        this.addMuscleGroup(ABS);
    }
}
