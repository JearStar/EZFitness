package listofexercises.muscleexercises;

import model.MuscleExercise;

import java.util.ArrayList;

public class PushUp extends MuscleExercise {
    public PushUp() {
        this.workoutName = PSUP;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(PECS);
        this.addMuscleGroup(TRI);
        this.addMuscleGroup(FDELTS);
        this.addMuscleGroup(ABS);
    }
}
