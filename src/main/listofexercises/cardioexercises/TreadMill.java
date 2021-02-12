package listofexercises.cardioexercises;

import model.CardioExercise;

import java.util.ArrayList;

public class TreadMill extends CardioExercise {

    public TreadMill() {
        this.workoutName = TREAD;
        this.muscleGroup = new ArrayList<String>();

        this.addMuscleGroup(CARDIO);
        this.addMuscleGroup(QUADS);
        this.addMuscleGroup(HAMSTR);
        this.addMuscleGroup(GLUTES);
        this.addMuscleGroup(CALVES);
    }
}
