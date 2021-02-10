package model.listofexercises;

import model.Workout;

import java.util.ArrayList;

public class DumbellRaise extends Workout {
    public DumbellRaise() {
        this.workoutName = DRAISE;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(LDELTS);
        this.addMuscleGroup(TRAPS);
    }
}
