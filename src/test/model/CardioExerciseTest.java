package model;

import listofexercises.cardioexercises.Bicycle;
import model.exceptions.NegativeValueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CardioExerciseTest {
    CardioExercise testCardioExercise;

    @BeforeEach
    public void setup() {
        testCardioExercise = new Bicycle();
    }

    @Test
    public void testSetTime() {
        try {
            testCardioExercise.setTime(1);
            assertEquals(1, testCardioExercise.getTime());
            testCardioExercise.setTime(2);
            assertEquals(2, testCardioExercise.getTime());
            testCardioExercise.setTime(5);
            assertEquals(5, testCardioExercise.getTime());
        } catch (NegativeValueException e) {
            fail("Not expecting exception here");
        }
    }

    @Test
    public void testGetDetails() {
        try {
            testCardioExercise.setTime(10);
            assertEquals("Time: 10.0 minutes", testCardioExercise.getSummary());
        } catch (NegativeValueException e) {
            fail("Not expecting exception here");
        }
    }

    @Test
    public void testGoThroughWorkout() {
        try {
            List<Double> testData = new ArrayList<>();
            testData.add(25.0);
            testCardioExercise.goThroughWorkout(testData);

            assertEquals(25.0, testCardioExercise.getTime());
        } catch (NegativeValueException e) {
            fail("Not expecting exception here");
        }
    }

    @Test
    public void testGoThroughWorkoutNegative() {
        try {
            List<Double> testData = new ArrayList<>();
            testData.add(-10.0);
            testCardioExercise.goThroughWorkout(testData);
            fail("Was expecting exception here");
        } catch (NegativeValueException e) {
            //Pass
        }
    }


}
