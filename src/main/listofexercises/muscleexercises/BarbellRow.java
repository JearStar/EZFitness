package listofexercises.muscleexercises;

import model.MuscleExercise;

import java.util.ArrayList;

public class BarbellRow extends MuscleExercise {
    public BarbellRow() {
        this.workoutName = BROW;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(BI);
        this.addMuscleGroup(LATS);
        this.addMuscleGroup(TRAPS);
        this.addMuscleGroup(UBACK);
        this.addMuscleGroup(LBACK);
        this.addMuscleGroup(RDELTS);
    }
}
