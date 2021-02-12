package listofexercises.muscleexercises;

import model.MuscleExercise;

import java.util.ArrayList;

public class CalfRaise extends MuscleExercise {
    public CalfRaise() {
        this.workoutName = CALFR;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(CALVES);
    }
}
