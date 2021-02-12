package listofexercises.cardioexercises;

import model.CardioExercise;

import java.util.ArrayList;

public class Elliptical extends CardioExercise {
    public Elliptical() {
        this.workoutName = ELLPT;
        this.muscleGroup = new ArrayList<String>();

        this.addMuscleGroup(CARDIO);
        this.addMuscleGroup(QUADS);
        this.addMuscleGroup(HAMSTR);
        this.addMuscleGroup(GLUTES);
        this.addMuscleGroup(PECS);
        this.addMuscleGroup(BI);
        this.addMuscleGroup(TRI);
    }
}
