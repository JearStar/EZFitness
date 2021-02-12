package listofexercises.muscleexercises;

import model.MuscleExercise;

import java.util.ArrayList;

public class HamstringCurl extends MuscleExercise {
    public HamstringCurl() {
        this.workoutName = HMCURL;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(HAMSTR);
        this.addMuscleGroup(GLUTES);
    }
}
