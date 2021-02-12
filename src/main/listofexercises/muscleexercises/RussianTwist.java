package listofexercises.muscleexercises;

import model.MuscleExercise;

import java.util.ArrayList;

public class RussianTwist extends MuscleExercise {
    public RussianTwist() {
        this.workoutName = RTWIST;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(ABS);
        this.addMuscleGroup(OBLQ);
    }

}
