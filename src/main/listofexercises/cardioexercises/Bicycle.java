package listofexercises.cardioexercises;

import model.CardioExercise;

import java.util.ArrayList;

public class Bicycle extends CardioExercise {
    public Bicycle() {
        this.workoutName = BIKE;
        this.muscleGroup = new ArrayList<String>();

        this.addMuscleGroup(CARDIO);
        this.addMuscleGroup(QUADS);
        this.addMuscleGroup(HAMSTR);
        this.addMuscleGroup(GLUTES);
        this.addMuscleGroup(CALVES);
    }
}
