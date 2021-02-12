package listofexercises.muscleexercises;

import model.MuscleExercise;

import java.util.ArrayList;

public class ChinUp extends MuscleExercise {
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
