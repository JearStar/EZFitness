package listofexercises.muscleexercises;

import model.MuscleExercise;

import java.util.ArrayList;

public class DumbellRaise extends MuscleExercise {
    public DumbellRaise() {
        this.workoutName = DRAISE;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(LDELTS);
        this.addMuscleGroup(TRAPS);
    }
}
