package model.listofexercises;

import model.Workout;

import java.util.ArrayList;

public class MountainClimber extends Workout {
    public MountainClimber() {
        this.workoutName = MTCLB;
        this.muscleGroup = new ArrayList<String>();
        this.reps = new ArrayList<>();
        this.weights = new ArrayList<>();

        this.addMuscleGroup(ABS);
        this.addMuscleGroup(HAMSTR);
        this.addMuscleGroup(TRI);
        this.addMuscleGroup(FDELTS);
        this.addMuscleGroup(GLUTES);
        this.addMuscleGroup(QUADS);
    }
}
