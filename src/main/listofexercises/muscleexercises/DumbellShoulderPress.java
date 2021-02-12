package listofexercises.muscleexercises;

import model.MuscleExercise;

import java.util.ArrayList;

public class DumbellShoulderPress extends MuscleExercise {
    public DumbellShoulderPress() {
        this.workoutName = DSHPR;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(TRI);
        this.addMuscleGroup(FDELTS);
    }
}
