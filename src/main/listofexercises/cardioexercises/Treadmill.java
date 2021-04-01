package listofexercises.cardioexercises;

import model.CardioExercise;

import java.util.ArrayList;

public class Treadmill extends CardioExercise {

    public Treadmill() {
        this.workoutName = TREAD;
        this.muscleGroup = new ArrayList<String>();

        this.addMuscleGroup(CARDIO);
        this.addMuscleGroup(QUADS);
        this.addMuscleGroup(HAMSTR);
        this.addMuscleGroup(GLUTES);
        this.addMuscleGroup(CALVES);
    }
}
