package listofexercises.muscleexercises;

import model.MuscleExercise;

import java.util.ArrayList;

public class CableExtension extends MuscleExercise {
    public CableExtension() {
        this.workoutName = CEXT;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(TRI);
    }
}
