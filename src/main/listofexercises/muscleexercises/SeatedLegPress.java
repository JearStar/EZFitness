package listofexercises.muscleexercises;

import model.MuscleExercise;

import java.util.ArrayList;

public class SeatedLegPress extends MuscleExercise {
    public SeatedLegPress() {
        this.workoutName = STLGPRS;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(QUADS);
        this.addMuscleGroup(GLUTES);
        this.addMuscleGroup(CALVES);
        this.addMuscleGroup(HAMSTR);
    }
}
