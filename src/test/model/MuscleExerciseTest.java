package model;

import listofexercises.muscleexercises.BarbellPress;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MuscleExerciseTest {
    MuscleExercise testMuscleExercise;

    @BeforeEach
    public void setup() {
        testMuscleExercise = new BarbellPress();
    }

    @Test
    public void testSetNumberOfSets() {
        testMuscleExercise.setNumberOfSets(3);
        assertEquals(3, testMuscleExercise.getSets());
    }

    @Test
    public void testSetReps() {
        List<Integer> testListOfReps = new ArrayList<>();
        testListOfReps.add(5);
        testListOfReps.add(10);
        testListOfReps.add(8);

        testMuscleExercise.setReps(5);
        testMuscleExercise.setReps(10);
        testMuscleExercise.setReps(8);

        assertEquals(testListOfReps, testMuscleExercise.getReps());
    }

    @Test
    public void testSetWeight() {
        List<Integer> testListOfWeights = new ArrayList<>();
        testListOfWeights.add(210);
        testListOfWeights.add(195);
        testListOfWeights.add(180);

        testMuscleExercise.setWeight(210);
        testMuscleExercise.setWeight(195);
        testMuscleExercise.setWeight(180);

        assertEquals(testListOfWeights, testMuscleExercise.getWeight());
    }

    @Test
    public void testGetSummary() {
        testMuscleExercise.setNumberOfSets(3);

        testMuscleExercise.setWeight(200);
        testMuscleExercise.setWeight(195);
        testMuscleExercise.setWeight(180);

        testMuscleExercise.setReps(8);
        testMuscleExercise.setReps(10);
        testMuscleExercise.setReps(7);

        assertEquals("\nSets: 3" + "\nReps: 8 10 7 " + "\nWeights: 200 195 180 ",
                testMuscleExercise.getSummary());
    }

    @Test
    public void testGoThroughWorkout(){
        int sets = 3;
        List<Integer> testReps = new ArrayList<>();
        List<Integer> testWeights = new ArrayList<>();

        testReps.add(10);
        testReps.add(8);
        testReps.add(9);

        testWeights.add(200);
        testWeights.add(180);
        testWeights.add(195);

        testMuscleExercise.goThroughWorkout(sets, testReps, testWeights);
        assertEquals(sets, testMuscleExercise.getSets());
        assertEquals(testReps, testMuscleExercise.getReps());
        assertEquals(testWeights, testMuscleExercise.getWeight());

    }

}