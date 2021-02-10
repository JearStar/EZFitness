package model.listofexercises;

import model.Workout;

import java.util.ArrayList;

public class RussianTwist extends Workout {
    public RussianTwist() {
        this.workoutName = RTWIST;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(ABS);
        this.addMuscleGroup(OBLQ);
    }

}
