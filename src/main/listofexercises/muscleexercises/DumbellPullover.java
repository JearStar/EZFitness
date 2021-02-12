package listofexercises.muscleexercises;

import model.MuscleExercise;

import java.util.ArrayList;

public class DumbellPullover extends MuscleExercise {
    public DumbellPullover() {
        this.workoutName = DPULLO;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(TRI);
        this.addMuscleGroup(PECS);
        this.addMuscleGroup(LATS);
    }
}
