package listofexercises.muscleexercises;

import model.MuscleExercise;

import java.util.ArrayList;

public class CableFly extends MuscleExercise {
    public CableFly() {
        this.workoutName = CFLY;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(PECS);
        this.addMuscleGroup(FDELTS);
    }
}
