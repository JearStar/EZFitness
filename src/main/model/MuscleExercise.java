package model;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public abstract class MuscleExercise extends Workout {

    protected int sets;
    protected List<Integer> reps;
    protected List<Integer> weights;


    //MODIFIES: this
    //EFFECTS: sets weight of a set
    public void setWeight(int w) {
        this.weights.add(abs(w));
    }


    //MODIFIES: this
    //EFFECTS: sets number of sets of workout
    public void setNumberOfSets(int n) {
        this.sets = abs(n);
    }


    //MODIFIES: this
    //EFFECTS: sets number of reps of a set
    public void setReps(int n) {
        this.reps.add(abs(n));
    }


    //EFFECTS: returns list of weights for however many sets
    public List<Integer> getWeight() {
        return this.weights;
    }


    //EFFECTS: returns number of sets
    public int getSets() {
        return this.sets;
    }


    //EFFECTS: returns list of reps for however many sets
    public List<Integer> getReps() {
        return this.reps;
    }

    public static List<Integer> listOfDoubleToInteger(List<Double> originalList) {
        List<Integer> newList = new ArrayList<>();
        for (double n : originalList) {
            int newInt = (int) n;
            newList.add(newInt);
        }
        return newList;
    }

    //MODIFIES: this
    //EFFECTS: will set details of workout given details of a muscle exercise
    public void goThroughWorkout(List<Double> infoList) {
        List<Integer> detailList = listOfDoubleToInteger(infoList);
        setNumberOfSets(detailList.get(0));

        for (int i = 1; i <= (detailList.size() - 2); i += 2) {
            this.setReps(detailList.get(i));
        }

        for (int i = 2; i <= (detailList.size() - 1); i += 2) {
            this.setWeight(detailList.get(i));
        }
    }

    //EFFECTS: returns a string summarizing this workout
    public String getSummary() {
        String reps = "";
        String weights = "";
        String finalString = "";

        for (Integer i : this.getReps()) {
            reps = reps + i.toString() + " ";
        }
        for (Integer i : this.getWeight()) {
            weights = weights + i.toString() + " ";
        }

        finalString = "Sets: " + this.getSets() + "\nReps: " + reps + "\nWeights: " + weights;
        return finalString;
    }

}
