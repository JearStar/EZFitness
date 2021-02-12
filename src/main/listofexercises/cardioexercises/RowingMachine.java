package listofexercises.cardioexercises;

import model.CardioExercise;

import java.util.ArrayList;

public class RowingMachine extends CardioExercise {
    public RowingMachine() {
        this.workoutName = ROWING;
        this.muscleGroup = new ArrayList<String>();

        this.addMuscleGroup(CARDIO);
        this.addMuscleGroup(QUADS);
        this.addMuscleGroup(HAMSTR);
        this.addMuscleGroup(CALVES);
        this.addMuscleGroup(UBACK);
        this.addMuscleGroup(BI);
        this.addMuscleGroup(TRI);
        this.addMuscleGroup(RDELTS);
        this.addMuscleGroup(TRAPS);
    }
}
