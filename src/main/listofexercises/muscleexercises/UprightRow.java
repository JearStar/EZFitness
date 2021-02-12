package listofexercises.muscleexercises;

import model.MuscleExercise;

import java.util.ArrayList;

public class UprightRow extends MuscleExercise {
    public UprightRow() {
        this.workoutName = UROW;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(FDELTS);
        this.addMuscleGroup(RDELTS);
        this.addMuscleGroup(TRAPS);
        this.addMuscleGroup(BI);
    }
}
