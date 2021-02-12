package model;

import java.util.List;
import java.util.Scanner;

import static java.lang.Math.abs;

public abstract class MuscleExercise extends Workout {

    protected int sets;
    protected List<Integer> reps;
    protected List<Integer> weights;


    //REQUIRES: n >= 0
    //MODIFIES: this
    //EFFECTS: sets weight of a set
    public void setWeight(int w) {
        this.weights.add(abs(w));
    }


    //REQUIRES: n > 0
    //MODIFIES: this
    //EFFECTS: sets number of sets of workout
    public void setNumberOfSets(int n) {
        this.sets = n;
    }


    //REQUIRES: n > 0
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

    public void goThroughWorkout() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the number of sets for " + this.getWorkoutName());
        int sets = input.nextInt();
        this.setNumberOfSets(sets);
        for (int i = 0; i < this.getSets(); i++) {
            System.out.println("\nPlease enter the number of reps for set number " + (i + 1));
            int reps = input.nextInt();
            System.out.println("\nPlease enter the weight done for set " + (i + 1));
            int weight = input.nextInt();
            this.setReps(reps);
            this.setWeight(weight);
        }
    }

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

        finalString = "\nSets: " + this.getSets() + "\nReps: " + reps + "\nWeights: " + weights;
        return finalString;
    }

}
