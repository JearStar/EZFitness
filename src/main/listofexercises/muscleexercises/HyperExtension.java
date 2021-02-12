package listofexercises.muscleexercises;

import model.MuscleExercise;

import java.util.ArrayList;

public class HyperExtension extends MuscleExercise {
    public HyperExtension() {
        this.workoutName = HPREXT;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(LBACK);
        this.addMuscleGroup(GLUTES);
    }
}
