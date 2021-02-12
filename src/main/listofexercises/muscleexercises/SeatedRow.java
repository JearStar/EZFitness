package listofexercises.muscleexercises;

import model.MuscleExercise;

import java.util.ArrayList;

public class SeatedRow extends MuscleExercise {
    public SeatedRow() {
        this.workoutName = STROW;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(UBACK);
        this.addMuscleGroup(BI);
        this.addMuscleGroup(TRAPS);
        this.addMuscleGroup(RDELTS);
    }
}
