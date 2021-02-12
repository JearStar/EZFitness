package model;

import java.util.List;

public interface Exercises {

    //EFFECTS: sets muscle groups of workout
    public void addMuscleGroup(String s);

    //EFFECTS: returns list of muscle groups of workout
    public List<String> getMuscleGroup();

    //EFFECTS: returns workout name
    public String getWorkoutName();



}
