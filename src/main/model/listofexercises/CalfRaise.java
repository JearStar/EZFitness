package model.listofexercises;

import model.Workout;

import java.util.ArrayList;

public class CalfRaise extends Workout {
    public CalfRaise() {
        this.workoutName = CALFR;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(CALVES);
    }
}
