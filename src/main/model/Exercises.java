package model;

import java.util.List;

public interface Exercises {

    //REQUIRES: n > 0
    //MODIFIES: this
    //EFFECTS: sets number of sets of workout
    public void setNumberOfSets(int n);

    //EFFECTS: sets muscle groups of workout
    public void addMuscleGroup(String s);

    //REQUIRES: n > 0
    //MODIFIES: this
    //EFFECTS: sets number of reps of workout of a set
    public void setReps(int n);

    //EFFECTS: returns number of sets
    public int getSets();

    //EFFECTS: returns list of reps for however many sets
    public List<Integer> getReps();

    //EFFECTS: returns list of muscle groups of workout
    public List<String> getMuscleGroup();

    //EFFECTS: returns list of weights for however many sets
    public List<Integer> getWeight();

    //REQUIRES: n >= 0
    //MODIFIES: this
    //EFFECTS: sets weight of a set
    public void setWeight(int w);

    //EFFECTS: returns workout name
    public String getWorkoutName();



}
