package listofexercises.muscleexercises;

import model.MuscleExercise;

import java.util.ArrayList;

public class CableCurl extends MuscleExercise {
    public CableCurl() {
        this.workoutName = CCURL;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(BI);
    }
}
