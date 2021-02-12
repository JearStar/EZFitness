package listofexercises.muscleexercises;

import model.MuscleExercise;

import java.util.ArrayList;

public class Deadlift extends MuscleExercise {
    public Deadlift() {
        this.workoutName = DLIFT;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(LBACK);
        this.addMuscleGroup(QUADS);
        this.addMuscleGroup(GLUTES);
        this.addMuscleGroup(HAMSTR);
        this.addMuscleGroup(LATS);
        this.addMuscleGroup(TRAPS);
        this.addMuscleGroup(UBACK);
    }
}
