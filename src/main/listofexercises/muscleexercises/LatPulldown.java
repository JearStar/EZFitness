package listofexercises.muscleexercises;

import model.MuscleExercise;

import java.util.ArrayList;

public class LatPulldown extends MuscleExercise {
    public LatPulldown() {
        this.workoutName = LATPD;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(BI);
        this.addMuscleGroup(LATS);
        this.addMuscleGroup(UBACK);
        this.addMuscleGroup(RDELTS);
        this.addMuscleGroup(TRAPS);
    }
}
