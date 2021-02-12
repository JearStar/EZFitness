package listofexercises.muscleexercises;

import model.MuscleExercise;

import java.util.ArrayList;

public class LegRaise extends MuscleExercise {
    public LegRaise() {
        this.workoutName = LGRAISE;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(ABS);
        this.addMuscleGroup(OBLQ);
    }
}
