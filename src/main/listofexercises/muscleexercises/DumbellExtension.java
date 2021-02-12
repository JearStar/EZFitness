package listofexercises.muscleexercises;

import model.MuscleExercise;

import java.util.ArrayList;

public class DumbellExtension extends MuscleExercise {
    public DumbellExtension() {
        this.workoutName = DEXT;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(TRI);
    }
}
