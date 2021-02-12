package listofexercises.muscleexercises;

import model.MuscleExercise;

import java.util.ArrayList;

public class DumbellCurl extends MuscleExercise {
    public DumbellCurl() {
        this.workoutName = DCURL;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(BI);
    }
}
