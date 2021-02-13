package model;

import listofexercises.cardioexercises.Bicycle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardioExerciseTest {
    CardioExercise testCardioExercise;
    @BeforeEach
    public void setup(){
        testCardioExercise = new Bicycle();
    }

    @Test
    public void testSetTime(){
        testCardioExercise.setTime(-1);
        assertEquals(1, testCardioExercise.getTime());
        testCardioExercise.setTime(2);
        assertEquals(2, testCardioExercise.getTime());
        testCardioExercise.setTime(5);
        assertEquals(5, testCardioExercise.getTime());
    }

    @Test
    public void testGetDetails(){
        testCardioExercise.setTime(10);
        assertEquals("Time: 10.0 minutes", testCardioExercise.getSummary());
    }

    @Test
    public void testGoThroughWorkout(){
        double testTime = 25.0;
        testCardioExercise.goThroughWorkout(testTime);

        assertEquals(testTime, testCardioExercise.getTime());
    }

}
