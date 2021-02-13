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

        assertEquals("Sets: 3" + "\nReps: 8 10 7 " + "\nWeights: 200 195 180 ",
                testMuscleExercise.getSummary());
    }

    @Test
    public void testListOfDoubleToInt(){
        List<Double> testList = new ArrayList<>();
        List<Integer> expectedList = new ArrayList<>();

        testList.add(1.0);
        testList.add(2.0);
        testList.add(3.0);
        testList.add(4.0);
        testList.add(5.0);
        testList.add(6.0);
        testList.add(7.0);

        expectedList.add(1);
        expectedList.add(2);
        expectedList.add(3);
        expectedList.add(4);
        expectedList.add(5);
        expectedList.add(6);
        expectedList.add(7);

        assertEquals(expectedList, MuscleExercise.listOfDoubleToInteger(testList));

    }

    @Test
    public void testGoThroughWorkout() {
        List<Double> testData = new ArrayList<>();
        List<Integer> testReps = new ArrayList<>();
        List<Integer> testWeights = new ArrayList<>();

        testData.add(3.0);
        testData.add(10.0);
        testData.add(190.0);
        testData.add(8.0);
        testData.add(210.0);
        testData.add(9.0);
        testData.add(180.0);

        testReps.add(10);
        testReps.add(8);
        testReps.add(9);

        testWeights.add(190);
        testWeights.add(210);
        testWeights.add(180);

        testMuscleExercise.goThroughWorkout(testData);

        assertEquals(3, testMuscleExercise.getSets());
        assertEquals(testReps, testMuscleExercise.getReps());
        assertEquals(testWeights, testMuscleExercise.getWeight());

    }

}