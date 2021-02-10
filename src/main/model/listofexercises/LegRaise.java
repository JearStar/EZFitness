package model.listofexercises;

import model.Workout;

import java.util.ArrayList;

public class LegRaise extends Workout {
    public LegRaise() {
        this.workoutName = LGRAISE;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(ABS);
        this.addMuscleGroup(OBLQ);
    }
}
