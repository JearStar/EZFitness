package model;

import listofexercises.muscleexercises.BarbellPress;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}