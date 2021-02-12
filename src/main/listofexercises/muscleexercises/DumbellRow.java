package listofexercises.muscleexercises;

import model.MuscleExercise;

import java.util.ArrayList;

public class DumbellRow extends MuscleExercise {
    public DumbellRow() {
        this.workoutName = DROW;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(LATS);
        this.addMuscleGroup(UBACK);
        this.addMuscleGroup(BI);
        this.addMuscleGroup(RDELTS);
    }
}
